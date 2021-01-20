package com.arifahmadalfian.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.vo.Resource

class MovieViewModel(private val moviesRepository: MoviesRepository): ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = moviesRepository.getAllMovies()
}