package com.ovais.sadapaycasestudy.features.home.data

data class GithubRepositoryUIData(
    val ownerName: String,
    val repositoryName: String,
    val language: String,
    val description: String,
    val starsCount: Int,
    val ownerImage: String,
    val id:Int
)