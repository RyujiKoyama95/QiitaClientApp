package com.example.qootaclient.repository

import com.example.qootaclient.data.Article
import com.example.qootaclient.data.Dao
import com.example.qootaclient.model.QiitaApiArticle
import com.example.qootaclient.model.asDatabaseModel
import com.example.qootaclient.network.QiitaService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ArticleRepository(private val dao: Dao) {
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

    /**
     * API通信で取得したデータをローカルデータベースで保持する
     */
    suspend fun refreshArticles(query: String) {
        val videos = qiitaService.searchArticle(query).body()
        if (videos != null) {
            dao.insertAll(videos.asDatabaseModel())
        }
    }

    suspend fun getArticles(): List<Article> = dao.getArticles()
}