package com.arifahmadalfian.movie.utils

import android.content.Context
import com.arifahmadalfian.movie.data.source.remote.response.MovieResponse
import com.arifahmadalfian.movie.data.source.remote.response.TvshowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val id = course.getString("id")
                val title = course.getString("title")
                val desc = course.getString("description")
                val release = course.getString("release")
                val bookmarked = course.getBoolean("bookmarked")
                val imgPath = course.getString("imgPath")

                val courseResponse = MovieResponse(id, title, desc, release, bookmarked, imgPath)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvshow(): List<TvshowResponse> {
        val listTvshow = ArrayList<TvshowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val id = course.getString("id")
                val title = course.getString("title")
                val desc = course.getString("description")
                val release = course.getString("release")
                val bookmarked = course.getBoolean("bookmarked")
                val imgPath = course.getString("imgPath")

                val courseResponse = TvshowResponse(id, title, desc, release, bookmarked, imgPath)
                listTvshow.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listTvshow
    }

    fun loadMoviesById(mId: String): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)
                if (course.getString("id") == mId){
                    val id = course.getString("id")
                    val title = course.getString("title")
                    val desc = course.getString("description")
                    val release = course.getString("release")
                    val bookmarked = course.getBoolean("bookmarked")
                    val imgPath = course.getString("imgPath")

                    val courseResponse = MovieResponse(id, title, desc, release, bookmarked, imgPath)
                    list.add(courseResponse)
                }

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvshowById(mId: String): List<TvshowResponse> {
        val listTvshow = ArrayList<TvshowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)
                if (course.getString("id") == mId) {
                    val id = course.getString("id")
                    val title = course.getString("title")
                    val desc = course.getString("description")
                    val release = course.getString("release")
                    val bookmarked = course.getBoolean("bookmarked")
                    val imgPath = course.getString("imgPath")

                    val courseResponse = TvshowResponse(id, title, desc, release, bookmarked, imgPath)
                    listTvshow.add(courseResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listTvshow
    }
}