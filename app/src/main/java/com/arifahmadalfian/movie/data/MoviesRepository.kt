package com.arifahmadalfian.movie.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.source.local.LocalDataSource
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.data.source.remote.ApiResponse
import com.arifahmadalfian.movie.data.source.remote.RemoteDataSource
import com.arifahmadalfian.movie.data.source.remote.response.MovieResponse
import com.arifahmadalfian.movie.data.source.remote.response.TvshowResponse
import com.arifahmadalfian.movie.utils.AppExecutors
import com.arifahmadalfian.movie.utils.PagedListConfig
import com.arifahmadalfian.movie.vo.Resource

class MoviesRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): MoviesDataSource {

    companion object {
        @Volatile
        private var instance: MoviesRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): MoviesRepository =
            instance ?: synchronized(this) {
                instance ?: MoviesRepository(remoteDataSource, localDataSource, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object: NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedListConfig.getPagedListConfig()
               return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMovies()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val courseListMovie = ArrayList<MovieEntity>()
                for (response in data) {
                    val course = MovieEntity(
                        response.id,
                        response.title,
                        response.descripiton,
                        response.release,
                        false,
                        response.imgPath
                    )
                    courseListMovie.add(course)
                }

                localDataSource.insertMovie(courseListMovie)
            }

        }.asLiveData()
    }

    override fun getAllTvshow(): LiveData<Resource<PagedList<TvshowEntity>>> {
        return object: NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvshowEntity>> {
                val config = PagedListConfig.getPagedListConfig()
                return LivePagedListBuilder(localDataSource.getAllTvshows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> {
                return remoteDataSource.getTvshow()
            }

            override fun saveCallResult(data: List<TvshowResponse>) {
                val courseListTvshow = ArrayList<TvshowEntity>()
                for (response in data) {
                    val course = TvshowEntity(
                        response.id,
                        response.title,
                        response.descripiton,
                        response.release,
                        false,
                        response.imgPath
                    )
                    courseListTvshow.add(course)
                }
                localDataSource.insertTvshow(courseListTvshow)
            }

        }.asLiveData()
    }

    override fun getMovieById(id:String): LiveData<Resource<MovieEntity>> {
        return object: NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getMoviesById(id)
            }

            override fun shouldFetch(data: MovieEntity?): Boolean {
                return data?.id == null || data.id.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMovieById(id)
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val courseListMovie = ArrayList<MovieEntity>()
                for (response in data) {
                    if (response.id == id) {
                        val course = MovieEntity(
                            response.id,
                            response.title,
                            response.descripiton,
                            response.release,
                            false,
                            response.imgPath
                        )
                        courseListMovie.add(course)
                    }
                }

                localDataSource.insertMovie(courseListMovie)
            }

        }.asLiveData()
    }

    override fun getTvshowById(id: String): LiveData<Resource<TvshowEntity>> {
        return object: NetworkBoundResource<TvshowEntity, List<TvshowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvshowEntity> {
                return localDataSource.getTvshowById(id)
            }

            override fun shouldFetch(data: TvshowEntity?): Boolean {
                return data?.id == null || data.id.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> {
                return remoteDataSource.getTvshowById(id)
            }

            override fun saveCallResult(data: List<TvshowResponse>) {
                val courseListTvshow = ArrayList<TvshowEntity>()
                for (response in data) {
                    if (response.id == id) {
                        val course = TvshowEntity(
                            response.id,
                            response.title,
                            response.descripiton,
                            response.release,
                            false,
                            response.imgPath
                        )
                        courseListTvshow.add(course)
                    }
                }

                localDataSource.insertTvshow(courseListTvshow)
            }

        }.asLiveData()
    }


    override fun getBookmarkedMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedListConfig.getPagedListConfig()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovie(), config).build()
    }

    override fun getBookmarkedTvshow(): LiveData<PagedList<TvshowEntity>> {
        val config = PagedListConfig.getPagedListConfig()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvshow(), config).build()
    }

    override fun setMovieBookmark(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movie, state) }
    }

    override fun setTvshowBookmark(tvshow: TvshowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvshowBookmark(tvshow, state) }
    }
}