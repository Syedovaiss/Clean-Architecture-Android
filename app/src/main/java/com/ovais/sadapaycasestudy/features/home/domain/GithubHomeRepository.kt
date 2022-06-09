package com.ovais.sadapaycasestudy.features.home.domain

import com.ovais.sadapaycasestudy.features.home.data.GithubRepoResponse
import com.ovais.sadapaycasestudy.features.home.services.HomeAPIService
import com.ovais.sadapaycasestudy.utils.ResponseResult
import com.ovais.sadapaycasestudy.utils.execute
import javax.inject.Inject

interface GithubHomeRepository {

    suspend fun getGithubRepositories(filters: HashMap<String, String>): ResponseResult<GithubRepoResponse>
}

class DefaultGithubHomeRepository @Inject constructor(private val api: HomeAPIService) :
    GithubHomeRepository {

    override suspend fun getGithubRepositories(filters: HashMap<String, String>): ResponseResult<GithubRepoResponse> =
        execute { api.getGithubRepositories(filters) }

}

