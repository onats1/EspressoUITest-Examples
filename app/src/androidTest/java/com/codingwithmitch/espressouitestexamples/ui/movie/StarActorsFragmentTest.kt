package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest {

    @Test
    fun is_directorsListVisible() {

        val starActors =  arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val fragmentFactory = FragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", starActors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(starActors)
                )
            )
        )
    }
}