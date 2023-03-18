package com.example.cinemazilla.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemazilla.components.LoginTextField
import com.example.cinemazilla.widgets.AnimatedSuccessState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun LoginScreen() {
    val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
    val scope = rememberCoroutineScope()
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
    var isLoggingIn by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(state = scrollState),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(20.dp)) {
        LoginTextField(textState = emailState, label = "E-mail", showIcon = false)
        LoginTextField(textState = passwordState, label = "Password", showIcon = true)
        Button(modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
            onClick = {
                      keyboard?.hide()
                // TODO "Auth with firebase"
                isLoggingIn = !isLoggingIn
                scope.launch(Dispatchers.IO) {
                 delay(5000L)
                 isLoggingIn = false
                }


            }, enabled = validationState) {
            if (!isLoggingIn)
                Text("Login")
            else
                CircularProgressIndicator(color = Color.White)

        }
    }
}