@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.qootaclient.view.detail

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen() {
    Scaffold {
        Text(text = "詳細画面")
    }
}