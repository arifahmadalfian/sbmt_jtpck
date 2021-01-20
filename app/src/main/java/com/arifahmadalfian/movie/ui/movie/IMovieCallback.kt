package com.arifahmadalfian.movie.ui.movie

import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity

interface IMovieCallback {
    fun onMovieShare(movie: MovieEntity)
}