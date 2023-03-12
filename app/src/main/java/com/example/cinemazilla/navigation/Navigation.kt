package com.example.cinemazilla.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemazilla.screens.HomeScreen

@Composable
fun Navigation(padding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = Screens.HomeScreen.name) {

        composable(route = Screens.HomeScreen.name) {
            HomeScreen()
        }

    }
}