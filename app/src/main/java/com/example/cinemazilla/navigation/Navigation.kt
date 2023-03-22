package com.example.cinemazilla.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinemazilla.screens.DetailsScreen
import com.example.cinemazilla.screens.homescreen.HomeScreen
import com.example.cinemazilla.screens.homescreen.HomeViewModel
import com.example.cinemazilla.screens.loginscreen.LoginScreen

@Composable
fun Navigation(padding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = Screens.HomeScreen.name) {

        composable(route = Screens.HomeScreen.name) {
            val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(viewModel)
        }
        composable(route = "${Screens.DetailsScreen.name}/{movieId}",
        arguments = listOf(navArgument("movieId"){
            type = NavType.StringType
        })
        ) { navBackStackEntry ->
            DetailsScreen(
//                navBackStackEntry.arguments?.getString("movieId")
            )
        }
        
        composable(route = Screens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

    }
}