package com.ovais.sadapaycasestudy.home

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.ovais.sadapaycasestudy.features.home.data.*
import com.ovais.sadapaycasestudy.features.home.domain.*
import com.ovais.sadapaycasestudy.utils.*
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GithubRepositoriesUseCaseTest {

    private lateinit var githubRepositoriesUseCase: GithubRepositoriesUseCase

    @Mock
    private lateinit var repository: GithubHomeRepository

    @Mock
    private lateinit var githubRepositoryMapper: GithubRepositoryMapper

    @Mock
    private lateinit var errorStateMapper: ErrorStateMapper

    @Before
    fun setup() {
        githubRepositoriesUseCase =
            DefaultGithubRepositoriesUseCase(repository, githubRepositoryMapper, errorStateMapper)
    }

    @Test
    fun `on successful execution`() = runBlocking {
        val responseResult = ResponseResult.Success(getGithubRepoResponse())
        whenever(repository.getGithubRepositories(any())).thenReturn(responseResult)
        whenever(githubRepositoryMapper.map(any())).thenReturn(getListOfGithubRepoUiData())
        val expectedViewStates = arrayListOf<Resource<List<GithubRepositoryUIData>>>().apply {
            add(Resource.Loading)
            add(Resource.Success(getListOfGithubRepoUiData()))
        }.toTypedArray()

        val actual = githubRepositoriesUseCase(Unit).collectToList(2).toTypedArray()

        assertNotNull(actual[1])
        assertEquals(actual[1], expectedViewStates[1])
    }

    @Test
    fun `on failure execution`() = runBlocking {
        val errorResponse = ErrorResponse(404, "/search/repositories", "Not Found")
        val responseResult = ResponseResult.Failure(errorResponse)
        val viewError = ViewError("Not Found", 404)
        whenever(repository.getGithubRepositories(any())).thenReturn(responseResult)
        whenever(errorStateMapper.map(any())).thenReturn(Resource.Error(viewError))
        val expectedViewStates = arrayListOf<Resource<List<GithubRepositoryUIData>>>().apply {
            add(Resource.Loading)
            add(Resource.Error(viewError))
        }.toTypedArray()

        val actual = githubRepositoriesUseCase(Unit).collectToList(2).toTypedArray()

        assertNotNull(actual[1])
        assertEquals(actual[1], expectedViewStates[1])
    }

    private fun getGithubRepoResponse() = GithubRepoResponse(items = getRepos())
    private fun getRepos() = listOf(Item())
    private fun getListOfGithubRepoUiData() = listOf(getGithubRepoUIData())
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