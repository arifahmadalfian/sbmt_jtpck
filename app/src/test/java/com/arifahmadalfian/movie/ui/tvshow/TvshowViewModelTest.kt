package com.arifahmadalfian.movie.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @get:Rule
    var instanceTaskExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvshowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = TvshowViewModel(moviesRepository)
    }

    @Test
    fun getTvshow() {
        val dummyTvshow = Resource.success(pagedList)
        Mockito.`when`(dummyTvshow.data?.size).thenReturn(10)
        val tvshow = MutableLiveData<Resource<PagedList<TvshowEntity>>>()
        tvshow.value = dummyTvshow

        Mockito.`when`(moviesRepository.getAllTvshow()).thenReturn(tvshow)
        val tvshowEntities = viewModel.getTvshow().value?.data
        verify(moviesRepository).getAllTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities?.size)

        viewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}