package com.example.qootaclient.view.search

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qootaclient.data.Article
import com.example.qootaclient.data.ArticleDatabase
import com.example.qootaclient.repository.ArticleRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val application: Application): ViewModel() {
    private val dao = ArticleDatabase.getDatabase(application).dao()
    private val repo = ArticleRepository(dao)
    private var _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    fun refreshArticles(query: String) {
        viewModelScope.launch {
            repo.refreshArticles(query)
            val result = repo.getArticles()
            _articles.postValue(result ?: listOf())
        }
    }
}