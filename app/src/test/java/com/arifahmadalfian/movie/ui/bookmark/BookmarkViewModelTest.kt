package com.arifahmadalfian.movie.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvshow: Observer<PagedList<TvshowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvshow: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(moviesRepository)
    }

    @Test
    fun getBookmarksMovie() {
        val dummyMovie = pagedListMovie
        `when`(dummyMovie.size).thenReturn(10)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        `when`(moviesRepository.getBookmarkedMovie()).thenReturn(movies)
        val movieEntity = viewModel.getBookmarksMovie().value
        verify(moviesRepository).getBookmarkedMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getBookmarksMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getBookmarksTvshow() {
        val dummyTvshow = pagedListTvshow
        `when`(dummyTvshow.size).thenReturn(10)
        val tvshow = MutableLiveData<PagedList<TvshowEntity>>()
        tvshow.value = dummyTvshow

        `when`(moviesRepository.getBookmarkedTvshow()).thenReturn(tvshow)
        val tvshowEntity = viewModel.getBookmarksTvshow().value
        verify(moviesRepository).getBookmarkedTvshow()
        assertNotNull(tvshowEntity)
        assertEquals(10, tvshowEntity?.size)

        viewModel.getBookmarksTvshow().observeForever(observerTvshow)
        verify(observerTvshow).onChanged(dummyTvshow)
    }

}