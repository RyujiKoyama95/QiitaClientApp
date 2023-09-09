package com.example.qootaclient.network

import android.util.Log
import com.example.qootaclient.model.QiitaArticleResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class QiitaApiDataSourceImpl: QiitaApiDataSource {
    companion object {
        const val TAG = "QiitaApiDataSourceImpl"
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
    override suspend fun searchArticle(query: String): List<QiitaArticleResponse> {
        val response = qiitaService.searchArticle(query)
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        } else {
            val errorCode = response.code()
            val errorBody = response.errorBody()
            Log.e(TAG, "fail HTTP request. errorCode=$errorCode errorBody=$errorBody")
            throw HttpException()
        }
    }
}

class HttpException: Throwable()