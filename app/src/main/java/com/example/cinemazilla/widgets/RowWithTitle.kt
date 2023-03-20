package com.example.cinemazilla.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemazilla.components.LargeMovieCard

private val modifier = Modifier
    .fillMaxWidth()
    .height(250.dp)


@Preview
@Composable
fun PrevRow() {
    val list = listOf(1,2,3,4,5)
    RowWithTitle(moviesList = list, rowTitle = "Trending") {
        LargeMovieCard(item = it)
        
    }
}


@Composable
fun <T>RowWithTitle(moviesList: List<T>,rowTitle: String, item: @Composable (T) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
            Text(text = rowTitle)
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(moviesList) { item ->
                item(item)
            }

        }
        Divider(thickness = 1.dp)
    }
}