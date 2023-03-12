package com.example.cinemazilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.cinemazilla.navigation.Navigation
import com.example.cinemazilla.topappbar.CinemaZillaTopAppBar
import com.example.cinemazilla.ui.theme.CinemaZillaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaZillaTheme {
                Scaffold(
                    topBar = {
                        CinemaZillaTopAppBar()
                    }
                ) {
                    Navigation(it)
                }
            }
        }
    }
}
