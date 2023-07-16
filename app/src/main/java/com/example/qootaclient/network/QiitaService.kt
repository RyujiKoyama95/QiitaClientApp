package com.example.qootaclient.network

import com.example.qootaclient.model.QiitaApiArticle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaService {
    companion object {
        const val BASE_URL = "https://qiita.com/"
    }

    @GET("api/v2/items?page=1&per_page=20")
    suspend fun searchArticle(@Query("query") query: String): Response<List<QiitaApiArticle>>
}