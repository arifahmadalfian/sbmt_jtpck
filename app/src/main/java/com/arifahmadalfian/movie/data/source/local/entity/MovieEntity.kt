package com.arifahmadalfian.movie.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movieentity")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var descripiton: String,

        @ColumnInfo(name = "release")
        var release: String,

        @ColumnInfo(name = "bookmarked")
        var bookmarked: Boolean = false,

        @ColumnInfo(name = "imgPath")
        var imgPath: String
)
