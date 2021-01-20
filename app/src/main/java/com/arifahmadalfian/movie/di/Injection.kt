package com.arifahmadalfian.movie.di

import android.content.Context
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.LocalDataSource
import com.arifahmadalfian.movie.data.source.local.room.MoviesDatabase
import com.arifahmadalfian.movie.data.source.remote.RemoteDataSource
import com.arifahmadalfian.movie.utils.AppExecutors
import com.arifahmadalfian.movie.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MoviesRepository {

        val database = MoviesDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.moviesDao())
        val appExecutors = AppExecutors()

        return MoviesRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}