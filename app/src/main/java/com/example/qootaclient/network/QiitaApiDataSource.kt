package com.example.qootaclient.network

import com.example.qootaclient.model.QiitaArticleResponse

interface QiitaApiDataSource {
    suspend fun fetchArticle(query: String): List<QiitaArticleResponse>
}