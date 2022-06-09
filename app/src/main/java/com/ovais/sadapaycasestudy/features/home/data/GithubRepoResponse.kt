package com.ovais.sadapaycasestudy.features.home.data

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Keep
@JsonClass(generateAdapter = true)
data class GithubRepoResponse(
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean? = false,
    val items: List<Item>? = emptyList(),
    @Json(name = "total_count")
    val totalCount: Int? = 0
) : Serializable