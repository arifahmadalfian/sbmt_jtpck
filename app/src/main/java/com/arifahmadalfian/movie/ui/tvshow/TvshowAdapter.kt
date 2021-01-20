package com.arifahmadalfian.movie.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.databinding.ItemsTvshowBinding
import com.arifahmadalfian.movie.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvshowAdapter(
    private val callback: ITvshowCallback
): PagedListAdapter<TvshowEntity, TvshowAdapter.TvshowViewHolder>(DIFF_CALLBACK) {

   companion object {
       private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<TvshowEntity>() {
           override fun areItemsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
               return oldItem.id == newItem.id
           }

           override fun areContentsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
               return oldItem == newItem
           }

       }
   }

    inner class TvshowViewHolder(private val binding: ItemsTvshowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvshowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemDate.text = itemView.resources.getString(R.string.release_date, tvshow.release)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA, tvshow.id)
                    intent.putExtra(DetailActivity.EXTRA_GENTRE, "tvshow")
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onTvshowShare(tvshow) }
                Glide.with(itemView.context)
                    .load(tvshow.imgPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_erorr))
                    .into(imgTvshow)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val itemsTvshowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(itemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

}