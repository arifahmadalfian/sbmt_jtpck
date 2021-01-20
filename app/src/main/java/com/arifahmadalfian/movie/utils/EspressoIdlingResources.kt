package com.arifahmadalfian.movie.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {
    private const val RESOURCES = "GLOBAL"
    val espressoTestIdlingResourse = CountingIdlingResource(RESOURCES)

    fun increment() {
        espressoTestIdlingResourse.increment()
    }

    fun decrement() {
        espressoTestIdlingResourse.decrement()
    }
}