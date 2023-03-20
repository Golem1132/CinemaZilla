package com.example.cinemazilla.screens.homescreen

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel(): ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser?.email
}