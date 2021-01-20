package com.arifahmadalfian.movie.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity

class BookmarkViewModel(private val moviesRepository: MoviesRepository): ViewModel() {
    fun getBookmarksMovie(): LiveData<PagedList<MovieEntity>> = moviesRepository.getBookmarkedMovie()

    fun getBookmarksTvshow(): LiveData<PagedList<TvshowEntity>> = moviesRepository.getBookmarkedTvshow()

    fun setBookmarkMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.bookmarked
        moviesRepository.setMovieBookmark(movieEntity, newState)
    }

    fun setBookmarkTvshow(tvshowEntity: TvshowEntity) {
        val newState = !tvshowEntity.bookmarked
        moviesRepository.setTvshowBookmark(tvshowEntity, newState)
    }
}