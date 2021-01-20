package com.arifahmadalfian.movie.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.databinding.ActivityHomeBinding
import com.arifahmadalfian.movie.ui.bookmark.BookmarkActivity


class HomeActivity : AppCompatActivity() {

    private var activityHomeBinding: ActivityHomeBinding? = null
    private val homeBinding get() = activityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding?.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        homeBinding?.viewPager?.adapter = sectionsPagerAdapter
        homeBinding?.tabs?.setupWithViewPager(homeBinding?.viewPager)

        setSupportActionBar(homeBinding?.toolbarHome)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = resources.getString(R.string.movie_amp_tv_show)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_list_bookmark) {
            val intent = Intent(this@HomeActivity, BookmarkActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}