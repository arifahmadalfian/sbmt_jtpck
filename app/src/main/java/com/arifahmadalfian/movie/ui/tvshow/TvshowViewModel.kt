package com.arifahmadalfian.movie.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifahmadalfian.movie.data.MoviesRepository
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.vo.Resource

class TvshowViewModel (private val moviesRepository: MoviesRepository): ViewModel() {
    fun getTvshow(): LiveData<Resource<PagedList<TvshowEntity>>> = moviesRepository.getAllTvshow()
}