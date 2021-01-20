package com.arifahmadalfian.movie.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.databinding.ActivityDetailBinding
import com.arifahmadalfian.movie.databinding.ContentDetailBinding
import com.arifahmadalfian.movie.viewmodel.ViewModelFactory
import com.arifahmadalfian.movie.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA = "extra"
        const val EXTRA_GENTRE = "extra_gentre"
    }

    private var activityMainBinding: ActivityDetailBinding? = null
    private val mainBinding get() = activityMainBinding
    private var gentre: String = ""
    private lateinit var viewModel: DetailActivityViewModel
    private var menu: Menu? = null
    private var contentDetailBinding: ContentDetailBinding? = null
    private val binding get() = contentDetailBinding

    private var action = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityDetailBinding.inflate(layoutInflater)
        contentDetailBinding = mainBinding?.detailContent

        setContentView(mainBinding?.root)

        setSupportActionBar(mainBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailActivityViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA)
            if (id != null) {
                gentre = extras.getString(EXTRA_GENTRE).toString()

                if (gentre == "movie") {
                    viewModel.setMovieId(id)
                    viewModel.getMovie().observe(this, {
                        when (it.status) {
                            Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS-> if(it.data != null) {
                                mainBinding?.progressBar?.visibility = View.GONE
                                mainBinding?.content?.visibility = View.VISIBLE

                                populateMovie(it.data)
                            }
                            Status.ERROR -> {
                                mainBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }

                    })
                } else {
                    viewModel.setTvshowId(id)
                    viewModel.getTvshow().observe(this, {
                        when (it.status) {
                            Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS-> if(it.data != null) {
                                mainBinding?.progressBar?.visibility = View.GONE
                                mainBinding?.content?.visibility = View.VISIBLE

                                populateTvshow(it.data)
                            }
                            Status.ERROR -> {
                                mainBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })

                }
            }
        }
    }

    private fun populateMovie(movies: MovieEntity) {
        binding?.txtJudul?.text = movies.title
        binding?.txtRelease?.text = resources.getString(R.string.release_date, movies.release)
        binding?.txtDescription?.text = movies.descripiton

        binding?.imgPoster?.let {
            Glide.with(this)
                .load(movies.imgPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_erorr))
                .into(it)
        }
    }

    private fun populateTvshow(tvshow: TvshowEntity) {
        binding?.txtJudul?.text = tvshow.title
        binding?.txtRelease?.text = resources.getString(R.string.release_date, tvshow.release)
        binding?.txtDescription?.text = tvshow.descripiton

        binding?.imgPoster?.let {
            Glide.with(this)
                .load(tvshow.imgPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_erorr))
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        if (gentre == "movie") {
            viewModel.getMovie().observe(this, {
                when (it.status) {
                    Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS-> if(it.data != null) {
                        mainBinding?.progressBar?.visibility = View.GONE
                        val state = it.data.bookmarked
                        setBookmarkState(state)
                        action = state
                    }
                    Status.ERROR -> {
                        mainBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        } else {
            viewModel.getTvshow().observe(this, {
                when (it.status) {
                    Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS-> if(it.data != null) {
                        mainBinding?.progressBar?.visibility = View.GONE
                        val state = it.data.bookmarked
                        setBookmarkState(state)
                        action = state
                    }
                    Status.ERROR -> {
                        mainBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            if (gentre == "movie") {
                viewModel.setBookmarkMovie()
                if (!action) {
                    Toast.makeText(this, "Menambahkan Movie ke bookmark", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Menghapus Movie dari bookmark", Toast.LENGTH_LONG).show()
                }
            } else {
                viewModel.setBookmarkTvshow()
                if (!action) {
                    Toast.makeText(this, "Menambahkan Tvshow ke bookmark", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Menghapus Tvshow dari bookmark", Toast.LENGTH_LONG).show()
                }
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_bookmark_24)
        }  else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_bookmark_border_24)
        }
    }


}