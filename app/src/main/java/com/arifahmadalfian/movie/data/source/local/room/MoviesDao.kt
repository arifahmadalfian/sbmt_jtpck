package com.arifahmadalfian.movie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movieentity")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity")
    fun getTvshows(): DataSource.Factory<Int, TvshowEntity>

    @Query("SELECT * FROM movieentity WHERE bookmarked = 1")
    fun getBookmarkedMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity WHERE bookmarked = 1")
    fun getBookmarkedTvshow(): DataSource.Factory<Int, TvshowEntity>

    @Query("SELECT * FROM movieentity WHERE id = :id")
    fun getMoviesById(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentity WHERE id = :id")
    fun getTvshowById(id: String): LiveData<TvshowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshow(tvshow: List<TvshowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvshow(tvshow: TvshowEntity)
}