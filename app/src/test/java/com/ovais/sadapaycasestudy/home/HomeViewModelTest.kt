package com.ovais.sadapaycasestudy.home

import com.nhaarman.mockitokotlin2.*
import com.ovais.sadapaycasestudy.R
import com.ovais.sadapaycasestudy.base.BaseViewModelTest
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.features.home.domain.GithubRepositoriesUseCase
import com.ovais.sadapaycasestudy.features.home.presentation.HomeViewModel
import com.ovais.sadapaycasestudy.managers.StringResourceManager
import com.ovais.sadapaycasestudy.managers.ToastManager
import com.ovais.sadapaycasestudy.utils.*
import junit.framework.TestCase.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock

@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseViewModelTest() {

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var githubHomeUseCase: GithubRepositoriesUseCase

    @Mock
    private lateinit var toastManager: ToastManager

    @Mock
    private lateinit var stringResourceManager: StringResourceManager

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(githubHomeUseCase, toastManager, stringResourceManager)
    }

    @Test
    fun `fetch github repositories successfully`() = runBlocking {
        whenever(githubHomeUseCase(Unit)).thenReturn(
            flowOf(
                Resource.Success(listOf(getGithubRepoUIData()))
            )
        )

        homeViewModel.onInitGithubRepositories()

        assertNotNull(homeViewModel.githubRepositoriesData.value)
        assertFalse(homeViewModel.errorViewVisibility.value.default)
        assertEquals(homeViewModel.githubRepositoriesData.value, listOf(getGithubRepoUIData()))
        assertFalse(homeViewModel.shimmerState.value.default)

    }

    @Test
    fun `fetch unsuccessful github repositories`() = runBlocking {
        val errorMessage = "Forbidden"
        val viewError = ViewError(errorMessage, 402)
        whenever(githubHomeUseCase(Unit)).thenReturn(
            flowOf(
                Resource.Error(viewError)
            )
        )

        homeViewModel.onInitGithubRepositories()

        assertTrue(homeViewModel.errorViewVisibility.value.default)
        assertFalse(homeViewModel.shimmerState.value.default)
        verify(toastManager).showToast(errorMessage)

    }

    @Test
    fun `on repository tapped`() = runBlocking {
        val message = "You have tapped repository"
        whenever(
            stringResourceManager.getString(
                eq(R.string.item_tapped_message),
                anyString(),
                anyString()
            )
        ).thenReturn(
            message
        )

        homeViewModel.onItemSelected(getGithubRepoUIData())

        verify(toastManager).showToast(message)
    }

    @Test
    fun `on retry success`() = runBlocking {
        whenever(githubHomeUseCase(Unit)).thenReturn(
            flowOf(
                Resource.Success(listOf(getGithubRepoUIData()))
            )
        )

        homeViewModel.onRetry()

        assertNotNull(homeViewModel.githubRepositoriesData.value)
        assertFalse(homeViewModel.errorViewVisibility.value.default)
        assertEquals(homeViewModel.githubRepositoriesData.value, listOf(getGithubRepoUIData()))
        assertFalse(homeViewModel.shimmerState.value.default)
    }

    @Test
    fun `on retry failure`() = runBlocking {
        val errorMessage = "Forbidden"
        val viewError = ViewError(errorMessage, 402)
        whenever(githubHomeUseCase(Unit)).thenReturn(
            flowOf(
                Resource.Error(viewError)
            )
        )

        homeViewModel.onRetry()

        assertTrue(homeViewModel.errorViewVisibility.value.default)
        assertFalse(homeViewModel.shimmerState.value.default)
        verify(toastManager).showToast(errorMessage)
    }

    private fun getGithubRepoUIData() = GithubRepositoryUIData(
        "Ovais",
        "SadaPay Case Study",
        "kotlin",
        "Case study description",
        123,
        "image-12345.jpg",
        1
    )
}