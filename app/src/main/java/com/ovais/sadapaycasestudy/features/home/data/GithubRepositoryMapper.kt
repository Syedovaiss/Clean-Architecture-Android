package com.ovais.sadapaycasestudy.features.home.data

import com.ovais.sadapaycasestudy.base.BaseMapper
import com.ovais.sadapaycasestudy.utils.default
import javax.inject.Inject

interface GithubRepositoryMapper : BaseMapper<List<Item>, List<GithubRepositoryUIData>>

class DefaultGithubRepositoryMapper @Inject constructor() : GithubRepositoryMapper {

    override fun map(from: List<Item>): List<GithubRepositoryUIData> = from.map { item ->
        GithubRepositoryUIData(
            ownerImage = item.owner?.avatarUrl.default(),
            ownerName = item.owner?.login.default(),
            repositoryName = item.name.default(),
            language = item.language.default(),
            description = item.description.default(),
            starsCount = item.stargazersCount.default(),
            id = item.id.default()
        )
    }
}