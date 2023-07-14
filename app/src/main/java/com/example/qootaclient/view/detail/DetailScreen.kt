@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.qootaclient.view.detail

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(url: String) {
    AndroidView(factory = { context ->
        Log.d("DetailScreen", "context=$context")

        WebView(context).apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })

    // 以下の書き方でも可
//    AndroidView(
//        factory = ::WebView,
//        update = { webView ->
//            webView.webViewClient = WebViewClient()
//            webView.loadUrl(url)
//        }
//    )
}