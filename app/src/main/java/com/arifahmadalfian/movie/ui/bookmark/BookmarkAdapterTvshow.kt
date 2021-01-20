package com.arifahmadalfian.movie.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.databinding.ItemsBookmarkBinding
import com.arifahmadalfian.movie.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BookmarkAdapterTvshow: PagedListAdapter<TvshowEntity, BookmarkAdapterTvshow.BookmarkViewHolder>(DIFF_CALBACK) {

    inner class BookmarkViewHolder(private val binding: ItemsBookmarkBinding): RecyclerView.ViewHolder(binding.root) {
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
                Glide.with(itemView.context)
                    .load(tvshow.imgPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_erorr))
                    .into(imgBookmark)
            }
        }
    }

    companion object {
        private val DIFF_CALBACK = object : DiffUtil.ItemCallback<TvshowEntity>() {
            override fun areItemsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val itemsBookmarkBinding = ItemsBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    fun getSwipeData(swipedPosition: Int): TvshowEntity? = getItem(swipedPosition)

}