
package com.example.qootaclient.view.detail

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
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
}