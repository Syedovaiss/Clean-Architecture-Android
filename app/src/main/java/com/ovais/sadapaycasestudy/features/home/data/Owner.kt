package com.ovais.sadapaycasestudy.features.home.data

import androidx.annotation.Keep
import com.ovais.sadapaycasestudy.utils.Constants.EMPTY_STRING
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
@Keep
data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String? = EMPTY_STRING,
    @Json(name = "events_url")
    val eventsUrl: String? = EMPTY_STRING,
    @Json(name = "followers_url")
    val followersUrl: String? = EMPTY_STRING,
    @Json(name = "following_url")
    val followingUrl: String? = EMPTY_STRING,
    @Json(name = "gists_url")
    val gistsUrl: String? = EMPTY_STRING,
    @Json(name = "gravatar_id")
    val gravatarId: String? = EMPTY_STRING,
    @Json(name = "html_url")
    val htmlUrl: String? = EMPTY_STRING,
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "login")
    val login: String? = EMPTY_STRING,
    @Json(name = "node_id")
    val nodeId: String? = EMPTY_STRING,
    @Json(name = "organizations_url")
    val organizationsUrl: String? = EMPTY_STRING,
    @Json(name = "received_events_url")
    val receivedEventsUrl: String? = EMPTY_STRING,
    @Json(name = "repos_url")
    val reposUrl: String? = EMPTY_STRING,
    @Json(name = "site_admin")
    val siteAdmin: Boolean? = false,
    @Json(name = "starred_url")
    val starredUrl: String? = EMPTY_STRING,
    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String? = EMPTY_STRING,
    @Json(name = "type")
    val type: String? = EMPTY_STRING,
    @Json(name = "url")
    val url: String? = EMPTY_STRING
) : Serializable