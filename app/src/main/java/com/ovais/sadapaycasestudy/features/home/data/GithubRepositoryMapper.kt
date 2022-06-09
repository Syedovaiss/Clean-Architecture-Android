package com.ovais.sadapaycasestudy.features.home.data

import com.ovais.sadapaycasestudy.base.BaseMapper
import javax.inject.Inject

interface GithubRepositoryMapper : BaseMapper<GithubRepoResponse, GithubRepositoryUIData>

class DefaultGithubRepositoryMapper @Inject constructor() : GithubRepositoryMapper {

    override fun map(from: GithubRepoResponse): GithubRepositoryUIData {
        return GithubRepositoryUIData()
    }
}