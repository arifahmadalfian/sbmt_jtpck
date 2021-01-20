package com.arifahmadalfian.movie.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.databinding.FragmentTvshowBinding
import com.arifahmadalfian.movie.viewmodel.ViewModelFactory
import com.arifahmadalfian.movie.vo.Status

class TvshowFragment : Fragment(), ITvshowCallback {

    private var fragmentTvshowBinding: FragmentTvshowBinding? = null
    private val binding get() = fragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvshowViewModel::class.java]

            val adapter = TvshowAdapter(this)


            viewModel.getTvshow().observe(this, {
               if (it != null) {
                   when (it.status) {
                       Status.LOADING -> binding?.pbTvshow?.visibility = View.VISIBLE
                       Status.SUCCESS -> {
                           binding?.pbTvshow?.visibility = View.GONE
                           adapter.submitList(it.data)
                       }
                       Status.ERROR -> {
                           binding?.pbTvshow?.visibility = View.GONE
                           Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                       }
                   }
               }
            })

            with(binding?.rvTvshow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }

    override fun onTvshowShare(tvshow: TvshowEntity) {
        if (activity != null) {
            val nimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(nimeType)
                .setChooserTitle("Bagikan Tvshow ini sekarang.")
                .setText(resources.getString(R.string.share_text, tvshow.title))
                .startChooser()
        }
    }

}