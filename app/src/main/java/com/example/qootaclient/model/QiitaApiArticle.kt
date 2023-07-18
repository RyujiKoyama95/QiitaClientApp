package com.example.qootaclient.model

import com.example.qootaclient.data.Article
import com.squareup.moshi.Json

data class QiitaApiArticle(
    val url: String,
    val title: String,
    val userId: String,
    @Json(name = "profile_image_url") val profileImageUrl: String
)

fun List<Article>.asDatabaseModel(): List<Article> {
    return map {
        Article(
            id = 0,
            url = it.url,
            title = it.title,
            userId = it.userId,
            profileImageUrl = it.profileImageUrl
        )
    }
}