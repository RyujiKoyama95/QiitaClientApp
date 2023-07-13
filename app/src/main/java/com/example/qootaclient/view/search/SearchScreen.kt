package com.example.qootaclient.view.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.qootaclient.view.component.SearchView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    Scaffold {
        Column {
            SideEffect { Log.d("SearchScreen", "compose") }

            val textFieldState = remember { mutableStateOf(TextFieldValue("")) }
            SearchView(textFieldState = textFieldState) {
                // Todo: callback
            }
            LazyColumn(content = {
                items(30) {
                    SearchResultCell()
                }
            })
            Text(text = "検索画面")
            Button(onClick = { navController.navigate("detail") }) {
                Text(text = "詳細画面へ")
            }
        }
    }
}