package com.example.cinemazilla.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemazilla.components.LoginTextField

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun LoginScreen() {
    val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

    val keyboard = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()
    val emailState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }
    val validationState by remember(emailState.value, passwordState.value) {
        mutableStateOf(emailRegex.matches(emailState.value) && passwordState.value.length >= 8)
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(state = scrollState),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(20.dp)) {
        LoginTextField(textState = emailState, label = "E-mail", showIcon = false)
        LoginTextField(textState = passwordState, label = "Password", showIcon = true)
        Button(modifier = Modifier.fillMaxWidth(0.8f),
            onClick = {
                      keyboard?.hide()
                // TODO "Auth with firebase"

            }, enabled = validationState) {
            Text("Login")
        }
    }
}