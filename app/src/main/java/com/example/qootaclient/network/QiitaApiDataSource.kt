package com.example.qootaclient.network

import com.example.qootaclient.model.QiitaArticleResponse

interface QiitaApiDataSource {
    suspend fun searchArticle(query: String): List<QiitaArticleResponse>
}