package com.example.qootaclient.repository

import com.example.qootaclient.data.Article
import com.example.qootaclient.data.ArticleDao
import com.example.qootaclient.model.QiitaArticleResponse
import com.example.qootaclient.model.asDatabaseModel
import com.example.qootaclient.network.QiitaApiDataSourceImpl

class ArticleRepository(private val dao: ArticleDao) {
    private val qiitaApiDataSource = QiitaApiDataSourceImpl()

    /**
     * API通信で取得したデータをローカルデータベースで保持する
     */
    suspend fun refreshArticles(query: String) {
        val articles = fetchArticle(query)
        dao.deleteAll()
        dao.insertAll(articles.asDatabaseModel())
    }

    suspend fun getArticles(): List<Article> = dao.getArticles()

    private suspend fun fetchArticle(query: String): List<QiitaArticleResponse> =
        qiitaApiDataSource.fetchArticle(query)
}