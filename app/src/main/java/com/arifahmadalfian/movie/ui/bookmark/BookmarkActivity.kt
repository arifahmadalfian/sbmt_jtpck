package com.arifahmadalfian.movie.ui.bookmark

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.databinding.ActivityBookmarkBinding
import com.arifahmadalfian.movie.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class BookmarkActivity : AppCompatActivity() {

    private lateinit var factory: ViewModelFactory
    private var activityBookmarkBinding: ActivityBookmarkBinding? = null
    private val bookmarkBinding get() = activityBookmarkBinding

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var adapterMovie: BookmarkAdapterMovie
    private lateinit var adapterTvshow: BookmarkAdapterTvshow

    private var titles: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBookmarkBinding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(bookmarkBinding?.root)
        itemTouchHelper.attachToRecyclerView(bookmarkBinding?.rvBookmark)

        setSupportActionBar(bookmarkBinding?.toolbarBookmark)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titles = resources.getString(R.string.movie)
        supportActionBar?.title = resources.getString(R.string.title_activity_bookmark, titles)

        factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(BookmarkViewModel::class.java)

        if (titles == resources.getString(R.string.movie)) {
            getMovieBookmark()
        } else {
            getTvshowBookmark()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        @Suppress("CAST_NEVER_SUCCEEDS")
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val view = bookmarkBinding?.rvBookmark
            if (view != null) {
                if (titles == resources.getString(R.string.movie)) {
                    val swipedPosition = viewHolder.adapterPosition
                    val movieEntity = adapterMovie.getSwipeData(swipedPosition)
                    movieEntity?.let { viewModel.setBookmarkMovie(it) }

                    val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                    snackbar.setAction(R.string.message_ok) {
                        movieEntity?.let { viewModel.setBookmarkMovie(it) }
                    }
                    snackbar.show()
                } else {
                    val swipedPosition = viewHolder.adapterPosition
                    val tvshowEntity = adapterTvshow.getSwipeData(swipedPosition)
                    tvshowEntity?.let { viewModel.setBookmarkTvshow(it) }

                    val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                    snackbar.setAction(R.string.message_ok) {
                        tvshowEntity?.let { viewModel.setBookmarkTvshow(it) }
                    }
                    snackbar.show()
                }

            }
        }
    })

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bookmark, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_movie -> {
                titles = resources.getString(R.string.movie)
                supportActionBar?.title = resources.getString(R.string.title_activity_bookmark, titles)
                getMovieBookmark()
            }
            R.id.action_tvshow ->  {
                titles = resources.getString(R.string.tv_show)
                supportActionBar?.title = resources.getString(R.string.title_activity_bookmark, titles)
                getTvshowBookmark()
            }
        }
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    private fun getTvshowBookmark() {
        adapterTvshow = BookmarkAdapterTvshow()
        bookmarkBinding?.pbBookmark?.visibility = View.VISIBLE
        viewModel.getBookmarksTvshow().observe(this, {
            bookmarkBinding?.pbBookmark?.visibility = View.GONE
            adapterTvshow.submitList(it)
        })

        bookmarkBinding?.rvBookmark?.layoutManager = LinearLayoutManager(this)
        bookmarkBinding?.rvBookmark?.setHasFixedSize(true)
        bookmarkBinding?.rvBookmark?.adapter = adapterTvshow
    }

    private fun getMovieBookmark() {
        adapterMovie = BookmarkAdapterMovie()
        bookmarkBinding?.pbBookmark?.visibility = View.VISIBLE
        viewModel.getBookmarksMovie().observe(this, {
            bookmarkBinding?.pbBookmark?.visibility = View.GONE
            adapterMovie.submitList(it)
        })

        bookmarkBinding?.rvBookmark?.layoutManager = LinearLayoutManager(this)
        bookmarkBinding?.rvBookmark?.setHasFixedSize(true)
        bookmarkBinding?.rvBookmark?.adapter = adapterMovie
    }

}