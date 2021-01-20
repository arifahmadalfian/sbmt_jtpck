package com.arifahmadalfian.movie.ui.movie

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
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.databinding.FragmentMovieBinding
import com.arifahmadalfian.movie.viewmodel.ViewModelFactory
import com.arifahmadalfian.movie.vo.Status


class MovieFragment : Fragment(), IMovieCallback {

    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private val binding get() = fragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val adapter = MovieAdapter(this)

            viewModel.getMovie().observe(this, {
                if (it != null) {
                    when(it.status) {
                        Status.LOADING -> binding?.pbMovie?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.pbMovie?.visibility = View.GONE
                            adapter.submitList(it.data)
                        }
                        Status.ERROR -> {
                            binding?.pbMovie?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }

    override fun onMovieShare(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan Movie ini sekarang.")
                .setText(resources.getString(R.string.share_text, movie.title))
                .startChooser()
        }
    }

}