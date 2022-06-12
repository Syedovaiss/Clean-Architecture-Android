package com.ovais.sadapaycasestudy.app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ovais.sadapaycasestudy.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers.allOf
import org.junit.*
import org.junit.runner.RunWith

@HiltAndroidTest
@LargeTest
@RunWith(AndroidJUnit4::class)
class GithubActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule = ActivityScenarioRule(GithubActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun isActivityVisible() {
        onView(withId(R.id.activity_github)).check(matches(isDisplayed()))
    }

    @Test
    fun isToolbarDisplayed() {
        onView(
            allOf(
                withId(R.id.toolbar),
                withParent(
                    allOf(
                        withId(R.id.appBarLayout),
                        withParent(withId(R.id.activity_github))
                    )
                ),
                isDisplayed()
            )
        )
    }

    @Test
    fun verifyToolbarText() {
        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("Trending"))))
    }

    @Test
    fun isStartDestinationFragmentDisplayed() {
        val startDestinationId = R.id.githubRepoFragment
        onView(
            allOf(
                withId(startDestinationId), withParent(withId(R.id.activity_github)),
                isDisplayed()
            )
        )
    }
}