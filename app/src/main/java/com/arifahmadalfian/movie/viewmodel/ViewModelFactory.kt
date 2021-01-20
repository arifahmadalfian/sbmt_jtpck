package com.arifahmadalfian.movie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.di.Injection
import com.arifahmadalfian.movie.ui.bookmark.BookmarkViewModel
import com.arifahmadalfian.movie.ui.detail.DetailActivityViewModel
import com.arifahmadalfian.movie.ui.movie.MovieViewModel
import com.arifahmadalfian.movie.ui.tvshow.TvshowViewModel

class ViewModelFactory private constructor(
    private val mMoviesRepository: MoviesRepository
): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context) : ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(TvshowViewModel::class.java) -> {
                TvshowViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailActivityViewModel::class.java) -> {
                DetailActivityViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(mMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}