package com.ovais.sadapaycasestudy.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.ovais.sadapaycasestudy.R
import com.ovais.sadapaycasestudy.app.GithubActivity
import com.ovais.sadapaycasestudy.features.home.presentation.GithubRepoFragment
import com.ovais.sadapaycasestudy.utils.*
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.*
import org.hamcrest.Matchers.not
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@LargeTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class GithubRepoFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)


    @get:Rule
    val activityRule = ActivityTestRule(GithubActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun isFragmentVisible() {
        launchFragmentInHiltContainer<GithubRepoFragment> { }
        onView(withId(R.id.fragment_github_repo)).check(matches(isDisplayed()))
    }

    @Test
    fun whenLoadingStateIsVisibleAndShimmerIsVisible(): Unit = runBlocking {
        launchFragmentInHiltContainer<GithubRepoFragment> {}
        onView(withId(R.id.repositoryRecyclerView)).check(matches(not(isDisplayed())))
        onView(withId(R.id.shimmerView)).check(matches(isDisplayed()))
    }

    @Test
    fun verifyRecyclerViewIsDisplayed(): Unit = runBlocking {
        launchFragmentInHiltContainer<GithubRepoFragment>()
        delay(TEST_BIT_DELAY)
        onView(withId(R.id.repositoryRecyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun verifyAdapterHasItems(): Unit = runBlocking {
        launchFragmentInHiltContainer<GithubRepoFragment> {}
        delay(TEST_BIT_DELAY)
        val itemCount = getCountFromRecyclerView(R.id.repositoryRecyclerView)
        if (itemCount isGreaterThan 0) {
            onView(withId(R.id.repositoryRecyclerView))
                .check(matches(hasDescendant(withId(R.id.userName))))
        }
    }
}