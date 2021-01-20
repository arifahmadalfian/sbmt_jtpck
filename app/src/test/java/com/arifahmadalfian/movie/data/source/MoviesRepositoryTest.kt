package com.arifahmadalfian.movie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arifahmadalfian.movie.data.source.local.LocalDataSource
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.data.source.remote.RemoteDataSource
import com.arifahmadalfian.movie.utils.AppExecutors
import com.arifahmadalfian.movie.utils.DataDummy
import com.arifahmadalfian.movie.utils.LiveDataTestUtil
import com.arifahmadalfian.movie.utils.PagedListUtil
import com.arifahmadalfian.movie.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Test
import org.junit.Rule
import org.mockito.Mockito.*

class MoviesRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val moviesRepository = FakeMoviesRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val tvshowResponse = DataDummy.generateRemoteDummyTvshow()

    private val movieId = movieResponse[0].id
    private val tvshowId = tvshowResponse[0].id

    private val movieDummy = DataDummy.getDummyMovie()[0]
    private val tvshowDummy = DataDummy.getDummyTvshow()[0]


    @Test
    fun getAllMovies() {
        val dataSourceFactory= mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        moviesRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(
                DataDummy.generateRemoteDummyMovie()
        ))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvshow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getAllTvshows()).thenReturn(dataSourceFactory)
        moviesRepository.getAllTvshow()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(
                DataDummy.generateRemoteDummyTvshow()
        ))
        verify(local).getAllTvshows()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponse.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieById() {
        val movieEntity = MutableLiveData<MovieEntity>()
        `when`(local.getMoviesById(movieId)).thenReturn(movieEntity)
        moviesRepository.getMovieById(movieId)

        val movieEntities = Resource.success(movieResponse[0])
        verify(local).getMoviesById(movieId)
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse[0], movieEntities.data)
    }

    @Test
    fun getTvshowById() {
        val tvshowEntity = MutableLiveData<TvshowEntity>()
        `when`(local.getTvshowById(tvshowId)).thenReturn(tvshowEntity)
        moviesRepository.getTvshowById(tvshowId)

        val tvshowEntitiy = Resource.success(tvshowResponse[0])
        verify(local).getTvshowById(tvshowId)
        assertNotNull(tvshowEntitiy.data)
        assertEquals(tvshowResponse[0], tvshowEntitiy.data)
    }

    @Test
    fun getBookmarkedMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getBookmarkedMovie()).thenReturn(dataSourceFactory)
        moviesRepository.getBookmarkedMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(
                DataDummy.generateRemoteDummyMovie()
        ))
        verify(local).getBookmarkedMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getBookmarkedTvshow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getBookmarkedTvshow()).thenReturn(dataSourceFactory)
        moviesRepository.getBookmarkedTvshow()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(
                DataDummy.generateRemoteDummyTvshow()
        ))
        verify(local).getBookmarkedTvshow()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponse.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun setMovieBookmark() {
        val movieBookmarked = movieDummy.bookmarked
        val setMovie = local.setMovieBookmark(movieDummy, !movieBookmarked)
        verify(local).setMovieBookmark(movieDummy, !movieBookmarked)
        verifyNoMoreInteractions(local)
        assertNotNull(setMovie)
    }

    @Test
    fun setTvshowBookmark() {
        val tvshowBookmarked = tvshowDummy.bookmarked
        val setTvshow = local.setTvshowBookmark(tvshowDummy, !tvshowBookmarked)
        verify(local).setTvshowBookmark(tvshowDummy, !tvshowBookmarked)
        verifyNoMoreInteractions(local)
        assertNotNull(setTvshow)
    }

}