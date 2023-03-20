package com.example.cinemazilla.screens.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemazilla.components.LargeMovieCard
import com.example.cinemazilla.components.SmallMovieCard
import com.example.cinemazilla.widgets.RowWithTitle

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(scrollState),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(20.dp)) {
        RowWithTitle(moviesList = listOf<String>("","","","",""), rowTitle = "Newest movies") {
            LargeMovieCard(item = it)

        }
        RowWithTitle(moviesList = listOf<String>("","","","","",""), rowTitle = "Observed") {
            SmallMovieCard()
        }
        RowWithTitle(moviesList = listOf<String>("","","","",""), rowTitle = "Newest movies") {
            LargeMovieCard(item = it)

        }

    }
}

