package com.arifahmadalfian.movie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.utils.DataDummy
import com.arifahmadalfian.movie.vo.Resource
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class DetailActivityViewModelTest {

    private lateinit var viewModelMovies: DetailActivityViewModel
    private lateinit var viewModelTvshow: DetailActivityViewModel
    private val dummyMovie = DataDummy.generateRemoteDummyMovie()[0]
    private val dummyTvshow = DataDummy.generateRemoteDummyTvshow()[0]
    private val movieId = dummyMovie.id
    private val tvshowId = dummyTvshow.id

    @Mock
    private lateinit var idMovie: MutableLiveData<String>

    @Mock
    private lateinit var idTvshow: MutableLiveData<String>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        viewModelMovies = DetailActivityViewModel(moviesRepository)
        viewModelTvshow = DetailActivityViewModel(moviesRepository)
        viewModelMovies.setMovieId(movieId)
        viewModelTvshow.setTvshowId(tvshowId)

        this.idMovie.value = movieId
        this.idTvshow.value = tvshowId

    }

    @Test
    fun getMovie() {
        val movieEntity: LiveData<Resource<MovieEntity>> = Transformations.switchMap(idMovie) {
            moviesRepository.getMovieById(it)
        }
        val dummyMovies = Resource.success(movieEntity)
        val id = movieId
        `when`(moviesRepository.getMovieById(id)).thenReturn(movieEntity)
        assertNotNull(dummyMovies.data)
        assertEquals(dummyMovies.data, movieEntity)

    }

    @Test
    fun getTvshow() {
        val tvshowEntity: LiveData<Resource<TvshowEntity>> = Transformations.switchMap(idTvshow) {
            moviesRepository.getTvshowById(it)
        }
        val dummyTvshow = Resource.success(tvshowEntity)
        val id = tvshowId
        `when`(moviesRepository.getTvshowById(id)).thenReturn(tvshowEntity)
        assertNotNull(dummyTvshow.data)
        assertEquals(dummyTvshow.data, tvshowEntity)
    }

}