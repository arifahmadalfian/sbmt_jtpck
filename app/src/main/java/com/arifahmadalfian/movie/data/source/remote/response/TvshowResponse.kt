package com.arifahmadalfian.movie.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvshowResponse(
        var id: String,
        var title: String,
        var descripiton: String,
        var release: String,
        var bookmarked: Boolean = false,
        var imgPath: String
): Parcelable