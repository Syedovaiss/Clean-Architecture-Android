package com.ovais.sadapaycasestudy.features.home.data

import androidx.annotation.Keep
import com.ovais.sadapaycasestudy.utils.Constants.EMPTY_STRING
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Keep
@JsonClass(generateAdapter = true)
data class License(
    @Json(name = "key")
    val key: String? = EMPTY_STRING,
    @Json(name = "name")
    val name: String? = EMPTY_STRING,
    @Json(name = "node_id")
    val nodeId: String? = EMPTY_STRING,
    @Json(name = "spdx_id")
    val spdxId: String? = EMPTY_STRING,
    @Json(name = "url")
    val url: String? = EMPTY_STRING
): Serializable