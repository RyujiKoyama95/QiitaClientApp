package com.example.qootaclient

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qootaclient.ui.theme.QootaClientTheme
import com.example.qootaclient.view.detail.DetailScreen
import com.example.qootaclient.view.search.SearchScreen
import com.example.qootaclient.view.search.SearchViewModel
import com.example.qootaclient.view.search.SearchViewModelFactory

class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // JetpackComposeではcontextは最初の呼び出し元であるsetContent内でAndroidシステムによって自動生成される。
            // このcontextが下位のComposeに渡されていく
            val context = LocalContext.current
            Log.d(TAG, "context1=$context")

            QootaClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MainNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MainNavHost(navController: NavHostController) {
    val owner = LocalViewModelStoreOwner.current
    owner?.let {
        val viewModel = viewModel<SearchViewModel>(
            it,
            "SearchViewModel",
            SearchViewModelFactory(LocalContext.current.applicationContext as Application)
        )
        NavHost(navController = navController, startDestination = "search") {
            composable("search") { SearchScreen(navController, viewModel) }
            composable("detail/{url}") {
                it.arguments?.getString("url")?.let { url ->
                    DetailScreen(url = url)
                } ?: run { 
                    DetailScreen(url = "https://qiita.com/masato_ishikawa/items/7dc44d3bf28aedf8d2e2")
                }
            }
        }
    }
}