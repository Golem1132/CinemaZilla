package com.example.cinemazilla.screens.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemazilla.model.Film
import com.example.cinemazilla.repository.DbRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DbRepository): ViewModel() {

    private val _filmList = MutableStateFlow<List<Film>>(emptyList())
    val filmList = _filmList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFilms().distinctUntilChanged().collect {
                _filmList.value = it
            }
        }
    }

    private val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser?.email
}