package com.example.qootaclient.model

import com.example.qootaclient.data.Article
import com.squareup.moshi.Json

data class QiitaArticleResponse(
    val url: String,
    val title: String,
    val user: User
) {
    data class User(
        @Json(name = "id") val id: String,
        @Json(name = "profile_image_url") val profileImageUrl: String
    )
}

fun List<QiitaArticleResponse>.asDatabaseModel(): List<Article> {
    return map {
        Article(
            url = it.url,
            title = it.title,
            user = Article.User(
                it.user.id,
                it.user.profileImageUrl
            )
        )
    }
}