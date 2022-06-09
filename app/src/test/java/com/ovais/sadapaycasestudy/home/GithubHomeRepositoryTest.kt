package com.ovais.sadapaycasestudy.home

import com.nhaarman.mockitokotlin2.*
import com.ovais.sadapaycasestudy.features.home.data.GithubRepoResponse
import com.ovais.sadapaycasestudy.features.home.domain.DefaultGithubHomeRepository
import com.ovais.sadapaycasestudy.features.home.domain.GithubHomeRepository
import com.ovais.sadapaycasestudy.features.home.services.HomeAPIService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GithubHomeRepositoryTest {

    private lateinit var repository: GithubHomeRepository

    @Mock
    private lateinit var apiService: HomeAPIService

    @Before
    fun setup() {
        repository = DefaultGithubHomeRepository(apiService)
    }

    @Test
    fun `fetch github repositories`() = runBlocking {
        whenever(apiService.getGithubRepositories(any())).thenReturn(getGithubRepoResponse())

        repository.getGithubRepositories(hashMapOf())

        verify(apiService).getGithubRepositories(hashMapOf())
        assertEquals(apiService.getGithubRepositories(hashMapOf()), getGithubRepoResponse())
    }

    private fun getGithubRepoResponse() = GithubRepoResponse()
}
