package com.arifahmadalfian.movie.utils

import androidx.paging.PagedList

object PagedListConfig {

    private val configBuilder = PagedList.Config.Builder()
    .setEnablePlaceholders(false)
    .setInitialLoadSizeHint(4)
    .setPageSize(4)
    .build()

    fun getPagedListConfig(): PagedList.Config {
        return configBuilder
    }
}