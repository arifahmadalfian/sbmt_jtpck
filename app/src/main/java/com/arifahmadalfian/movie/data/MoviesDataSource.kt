package com.arifahmadalfian.movie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.vo.Resource

interface MoviesDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvshow(): LiveData<Resource<PagedList<TvshowEntity>>>

    fun getMovieById(id: String): LiveData<Resource<MovieEntity>>

    fun getTvshowById(id: String): LiveData<Resource<TvshowEntity>>

    fun getBookmarkedMovie(): LiveData<PagedList<MovieEntity>>

    fun getBookmarkedTvshow(): LiveData<PagedList<TvshowEntity>>

    fun setMovieBookmark(movie: MovieEntity, state: Boolean)

    fun setTvshowBookmark(tvshow: TvshowEntity, state: Boolean)
}