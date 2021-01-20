package com.arifahmadalfian.movie.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.arifahmadalfian.movie.R
import com.arifahmadalfian.movie.utils.DataDummy
import com.arifahmadalfian.movie.utils.EspressoIdlingResources
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomeActivityTest {

    private lateinit var context: Context

    private val dummyMovie = DataDummy.generateRemoteDummyMovie()
    private val dummyTvshow = DataDummy.generateRemoteDummyTvshow()
    private val lengthMovie = dummyMovie.size
    private val lengthTvshow = dummyTvshow.size


    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.espressoTestIdlingResourse)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.espressoTestIdlingResourse)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                lengthMovie
            )
        )
    }


    @Test
    fun loadTvshow() {
        onView(withText(R.string.tv_show)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        lengthTvshow
                )
        )
    }

    @Test
    fun loadDetailMovie() {
        loadMovieDetails()
    }

    @Test
    fun loadDetailTvshow() {
        loadTvshowDetails()
    }

    @Test
    fun loadBookmarkMovieAndDetailMovie() {
        loadMovieDetails()
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_list_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.action_list_bookmark)).perform(click())
        openActionBarOverflowOrOptionsMenu(context)
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.txtJudul)).check(matches((isDisplayed())))
        onView(withId(R.id.txtRelease)).check(matches((isDisplayed())))
        onView(withId(R.id.txtDescription)).check(matches(isDisplayed()))
        onView(isRoot()).perform(pressBack())
        onView(isRoot()).perform(pressBack())

        deleteBookmarkMovie()
    }

    @Test
    fun loadBookmarkTvshowAndDetailTvshow() {
        loadTvshowDetails()
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_list_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.action_list_bookmark)).perform(click())
        openActionBarOverflowOrOptionsMenu(context)
        onView(withText("Tv show")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.txtJudul)).check(matches((isDisplayed())))
        onView(withId(R.id.txtRelease)).check(matches((isDisplayed())))
        onView(withId(R.id.txtDescription)).check(matches(isDisplayed()))
        onView(isRoot()).perform(pressBack())
        onView(isRoot()).perform(pressBack())

        deleteBookmarkTvshow()
    }

    private fun deleteBookmarkMovie() {
        onView(withId(R.id.action_list_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.action_list_bookmark)).perform(click())
        openActionBarOverflowOrOptionsMenu(context)
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, swipeRight()))
        onView(isRoot()).perform(pressBack())
    }

    private fun deleteBookmarkTvshow() {
        onView(withId(R.id.action_list_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.action_list_bookmark)).perform(click())
        openActionBarOverflowOrOptionsMenu(context)
        onView(withText("Tv show")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, swipeRight()))
        onView(isRoot()).perform(pressBack())
    }

    private fun loadMovieDetails() {
        onView(withId(R.id.rv_movie)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        ViewActions.click()
                )
        )
        onView(withId(R.id.txtJudul)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtJudul)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.txtRelease)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtRelease)).check(matches(withText("Release ${dummyMovie[0].release}")))
        onView(withId(R.id.txtDescription)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtDescription)).check(matches(withText(dummyMovie[0].descripiton)))

    }

    private fun loadTvshowDetails() {
        onView(withText(R.string.tv_show)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.txtJudul)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtJudul)).check(matches(withText(dummyTvshow[0].title)))
        onView(withId(R.id.txtRelease)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtRelease)).check(matches(withText("Release ${dummyTvshow[0].release}")))
        onView(withId(R.id.txtDescription)).check(matches(not(doesNotExist())))
        onView(withId(R.id.txtDescription)).check(matches(withText(dummyTvshow[0].descripiton)))

    }


}