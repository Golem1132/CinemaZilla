package com.example.cinemazilla.screens.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    val signInStatus = MutableStateFlow<Boolean?>(null)

    fun logIn(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    signInStatus.tryEmit(it.isSuccessful)
                }
        }
    }

}