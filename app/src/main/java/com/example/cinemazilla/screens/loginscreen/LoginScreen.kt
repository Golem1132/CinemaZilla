package com.example.cinemazilla.screens.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cinemazilla.components.LoginTextField
import com.example.cinemazilla.navigation.Screens
import com.example.cinemazilla.widgets.AnimatedFailState
import com.example.cinemazilla.widgets.AnimatedSuccessState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    val vm = viewModel<LoginViewModel>()
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
    var isLoggingIn by remember {
        mutableStateOf(false)
    }
    val loginStatus = vm.signInStatus.collectAsState()
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
                isLoggingIn = !isLoggingIn
                vm.logIn(emailState.value,passwordState.value)
            }, enabled = validationState) {
            if (!isLoggingIn)
                Text("Login")
            else
                CircularProgressIndicator(color = Color.White)

        }
    }
    when(loginStatus.value) {
        null -> Box{}
        true -> AnimatedSuccessState() {
            isLoggingIn = !isLoggingIn
            navController.navigate(Screens.HomeScreen.name)
        }
        false -> AnimatedFailState(){
            vm.signInStatus.tryEmit(null)
            isLoggingIn = !isLoggingIn
        }
    }

}