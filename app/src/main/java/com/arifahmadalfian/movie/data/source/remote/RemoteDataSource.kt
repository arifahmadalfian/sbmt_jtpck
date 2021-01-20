package com.arifahmadalfian.movie.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifahmadalfian.movie.data.source.remote.response.MovieResponse
import com.arifahmadalfian.movie.data.source.remote.response.TvshowResponse
import com.arifahmadalfian.movie.utils.EspressoIdlingResources
import com.arifahmadalfian.movie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvshow(): LiveData<ApiResponse<List<TvshowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvshow = MutableLiveData<ApiResponse<List<TvshowResponse>>>()
        handler.postDelayed({
            resultTvshow.value = ApiResponse.success(jsonHelper.loadTvshow())
            EspressoIdlingResources.decrement()
         }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvshow
    }

    fun getMovieById(id: String): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMoviesById(id))
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvshowById(id: String): LiveData<ApiResponse<List<TvshowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvshow = MutableLiveData<ApiResponse<List<TvshowResponse>>>()
        handler.postDelayed({
            resultTvshow.value = ApiResponse.success(jsonHelper.loadTvshowById(id))
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvshow
    }
}