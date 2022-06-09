package com.ovais.sadapaycasestudy.features.home.services

import com.ovais.sadapaycasestudy.features.home.data.GithubRepoResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface HomeAPIService {

    @GET("/search/repositories")
    suspend fun getGithubRepositories(@QueryMap filters: HashMap<String, String>): GithubRepoResponse
}