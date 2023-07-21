package com.example.qootaclient.view.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.qootaclient.data.Article

@Composable
fun SearchResultCell(
    article: Article,
    onClick: ()->Unit
) {
    Log.d("SearchResultCell", "SearchResultCell called")
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable { onClick() }
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = article.title)
        Row(
            modifier = Modifier.height(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = article.user.profileImageUrl,
                contentDescription = "author icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "@${article.user.userId}")
        }
        Divider()
    }
}