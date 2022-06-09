package com.ovais.sadapaycasestudy.features.home.domain

import com.ovais.sadapaycasestudy.base.BaseFlowUseCase
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryMapper
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GithubRepositoriesUseCase : BaseFlowUseCase<Unit, Resource<GithubRepositoryUIData>>

class DefaultGithubRepositoriesUseCase @Inject constructor(
    private val repository: GithubHomeRepository,
    private val githubRepositoryMapper: GithubRepositoryMapper,
    private val errorStateMapper: ErrorStateMapper
) : GithubRepositoriesUseCase {

    override fun execute(parameters: Unit): Flow<Resource<GithubRepositoryUIData>> = flow {
        emit(Resource.Loading)
        emit(
            when (val response = repository.getGithubRepositories(getFilters())) {
                is ResponseResult.Success -> Resource.Success(githubRepositoryMapper.map(response.data))
                else -> errorStateMapper.map(response)
            }
        )
    }

    private fun getFilters() = hashMapOf("sort" to "stars", "q" to "language")

}