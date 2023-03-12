package com.example.cinemazilla.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Preview
@Composable
fun DetailsScreen() {
    val verticalScrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(verticalScrollState)) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEndPercent = 10, bottomStartPercent = 10)),
            contentScale = ContentScale.Fit,
            model = "https://images.unsplash.com/photo-1674574124473-e91fdcabaefc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            contentDescription = ""
        ) {
            SubcomposeAsyncImageContent()
        }
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")
        Text(text = "TITLE")

    }
}