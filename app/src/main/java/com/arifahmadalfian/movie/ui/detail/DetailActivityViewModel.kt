package com.arifahmadalfian.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.ui.bookmark.BookmarkViewModel
import com.arifahmadalfian.movie.vo.Resource

class DetailActivityViewModel(private val moviesRepository: MoviesRepository): ViewModel() {

    private val movieId = MutableLiveData<String>()
    private val tvshowId = MutableLiveData<String>()

    private val movieEntity: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        moviesRepository.getMovieById(mMovieId)
    }

    private val tvshowEntity: LiveData<Resource<TvshowEntity>> = Transformations.switchMap(tvshowId) { mTvshowId ->
        moviesRepository.getTvshowById(mTvshowId)
    }

    fun getMovie(): LiveData<Resource<MovieEntity>> {
        return movieEntity
    }

    fun getTvshow(): LiveData<Resource<TvshowEntity>> {
        return tvshowEntity
    }

    fun setMovieId(movieId: String) {
        this.movieId.value = movieId
    }

    fun setTvshowId(tvshowId: String) {
        this.tvshowId.value = tvshowId
    }

    fun setBookmarkMovie() {
        val movie = movieEntity.value
        if (movie != null) {
            val aMovie = movie.data
            if (aMovie != null) {
                val newState = !aMovie.bookmarked
                moviesRepository.setMovieBookmark(aMovie, newState)
            }
        }

    }

    fun setBookmarkTvshow() {
        val tvshow = tvshowEntity.value
        if (tvshow != null) {
            val aTvshow = tvshow.data
            if (aTvshow != null) {
                val newState = !aTvshow.bookmarked
                moviesRepository.setTvshowBookmark(aTvshow, newState)
            }
        }

    }

}