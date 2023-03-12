package com.example.cinemazilla.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun LoginTextField(textState: MutableState<String>, label: String, showIcon: Boolean) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        visualTransformation = if (!isVisible && showIcon) PasswordVisualTransformation()
        else VisualTransformation.None,
        trailingIcon = {
            if (showIcon)
                Icon(
                    modifier = Modifier.clickable {
                        isVisible = !isVisible
                    },
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Show"
                )
            else Box {}
        },
        label = {
            Text(text = label)
        },
        singleLine = true,
    )
}