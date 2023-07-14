@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.qootaclient.view.detail

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import retrofit2.http.Url

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(url: Url) {
    val state = rememberWebViewState(url)
    WebView(state)
}