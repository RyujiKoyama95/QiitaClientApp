package com.example.qootaclient.repository

import com.example.qootaclient.model.QiitaApiArticle
import com.example.qootaclient.network.QiitaService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ArticleRepository {
    companion object {
        val qiitaService = Retrofit.Builder()
            .baseUrl(QiitaService.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(QiitaService::class.java)
    }

    suspend fun searchArticle(query: String): List<QiitaApiArticle>? =
        qiitaService.searchArticle(query).body()
}