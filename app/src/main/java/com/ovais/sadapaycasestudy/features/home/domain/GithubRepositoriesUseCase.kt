package com.ovais.sadapaycasestudy.features.home.domain

import com.ovais.sadapaycasestudy.base.BaseFlowUseCase
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryMapper
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.utils.*
import com.ovais.sadapaycasestudy.utils.Constants.KEY_Q
import com.ovais.sadapaycasestudy.utils.Constants.KEY_SORT
import com.ovais.sadapaycasestudy.utils.FILTERS.LANGUAGE
import com.ovais.sadapaycasestudy.utils.FILTERS.STARS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GithubRepositoriesUseCase : BaseFlowUseCase<Unit, Resource<List<GithubRepositoryUIData>>>

class DefaultGithubRepositoriesUseCase @Inject constructor(
    private val repository: GithubHomeRepository,
    private val githubRepositoryMapper: GithubRepositoryMapper,
    private val errorStateMapper: ErrorStateMapper
) : GithubRepositoriesUseCase {

    override fun execute(parameters: Unit): Flow<Resource<List<GithubRepositoryUIData>>> = flow {
        emit(Resource.Loading)
        emit(
            when (val response = repository.getGithubRepositories(getFilters())) {
                is ResponseResult.Success -> Resource.Success(githubRepositoryMapper.map(response.data.items.orEmptyList()))
                else -> errorStateMapper.map(response)
            }
        )
    }

    private fun getFilters() = hashMapOf(KEY_SORT to STARS, KEY_Q to LANGUAGE)

}