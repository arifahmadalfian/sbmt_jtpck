package com.arifahmadalfian.movie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.data.source.local.room.MoviesDao

class LocalDataSource private constructor(private val mMoviesDao: MoviesDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(moviesDao: MoviesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(moviesDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMoviesDao.getMovies()

    fun getAllTvshows(): DataSource.Factory<Int, TvshowEntity> = mMoviesDao.getTvshows()

    fun getMoviesById(id: String): LiveData<MovieEntity> = mMoviesDao.getMoviesById(id)

    fun getTvshowById(id: String): LiveData<TvshowEntity> = mMoviesDao.getTvshowById(id)

    fun getBookmarkedMovie(): DataSource.Factory<Int, MovieEntity> = mMoviesDao.getBookmarkedMovie()

    fun getBookmarkedTvshow(): DataSource.Factory<Int, TvshowEntity> = mMoviesDao.getBookmarkedTvshow()

    fun insertMovie(movie: List<MovieEntity>) = mMoviesDao.insertMovie(movie)

    fun insertTvshow(tvshow: List<TvshowEntity>) = mMoviesDao.insertTvshow(tvshow)

    fun setMovieBookmark(movie: MovieEntity, newState: Boolean) {
        movie.bookmarked = newState
        mMoviesDao.updateMovie(movie)
    }

    fun setTvshowBookmark(tvshow: TvshowEntity, newState: Boolean) {
        tvshow.bookmarked = newState
        mMoviesDao.updateTvshow(tvshow)
    }
}