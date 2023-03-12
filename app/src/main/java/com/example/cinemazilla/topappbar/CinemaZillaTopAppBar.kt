package com.example.cinemazilla.topappbar

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CinemaZillaTopAppBar() {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Image(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Navigate back/Search"
            )
        },
        title = {
          Text(text = "Title")
        },
        actions = {
            Image(imageVector = Icons.Default.Person, contentDescription = "Go to profile")
        }
    )
}