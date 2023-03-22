package com.example.cinemazilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import com.example.cinemazilla.navigation.Navigation
import com.example.cinemazilla.retrofit.api
import com.example.cinemazilla.topappbar.CinemaZillaTopAppBar
import com.example.cinemazilla.ui.theme.CinemaZillaTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
