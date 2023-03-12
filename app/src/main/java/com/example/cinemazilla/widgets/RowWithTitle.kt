package com.example.cinemazilla.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.cinemazilla.components.MovieCard

@Composable
fun RowWithTitle(title: String, icon: ImageVector) {
    Column {
        Row {
            Icon(imageVector = icon, contentDescription = "Icon for $title")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = title)
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(10) {
                MovieCard()
            }

        }
    }
}