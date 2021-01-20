package com.arifahmadalfian.movie.ui.tvshow

import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity

interface ITvshowCallback {
    fun onTvshowShare(tvshow: TvshowEntity)
}