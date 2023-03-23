package com.example.cinemazilla.screens.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemazilla.model.Film
import com.example.cinemazilla.repository.DbRepository
import com.example.cinemazilla.retrofit.CinemaZillaApi
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DbRepository, private val api: CinemaZillaApi): ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val _filmList = MutableStateFlow<List<Film>>(emptyList())
    val filmList = _filmList

    init {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", Locale.getDefault()).format(Date()).split("+")
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFilms().distinctUntilChanged().collect {
                _filmList.value = it
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            api.getFilmsNowShowing(date[0]).awaitResponse().let { response ->
                if(response.isSuccessful) {
                    if (response.body() != null) {
                        repository.clearTable()
                        repository.insertFilms(response.body()!!.films)
                    }
                }
            }
        }
    }


    val currentUser = auth.currentUser?.email
}