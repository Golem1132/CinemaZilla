package com.example.cinemazilla.widgets

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedSuccessState(doOnFinish:() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val size = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            size.animateTo(0.5f,
                animationSpec = tween(
                    durationMillis = 200,
                    delayMillis = 50,
                    easing = FastOutLinearInEasing
                )
            )
            delay(1000L)
            doOnFinish()
        }
        Image(
            modifier = Modifier
                .fillMaxSize(size.value)
                .aspectRatio(1f)
                .clip(CircleShape)
                .border(width = 10.dp, color = Color.Green, shape = CircleShape),
            imageVector = Icons.Default.Check, contentDescription = "",
            colorFilter = ColorFilter.tint(Color.Green, BlendMode.SrcIn)
        )
        Text(modifier = Modifier.fillMaxWidth(size.value),
            text = "SUCCESS",
            textAlign = TextAlign.Center)
    }
}

@Composable
fun AnimatedFailState(doOnFinish: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(20.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val size = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            size.animateTo(0.5f,
                animationSpec = tween(
                    durationMillis = 200,
                    delayMillis = 50,
                    easing = FastOutLinearInEasing
                )
            )
            delay(1000L)
            size.animateTo(0f,
                animationSpec = tween(
                    durationMillis = 200,
                    delayMillis = 50,
                    easing = FastOutLinearInEasing
                )
            )
            doOnFinish()
        }
            Image(
                modifier = Modifier
                    .fillMaxSize(size.value)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .border(width = 10.dp, color = Color.Red, shape = CircleShape),
                imageVector = Icons.Default.Close, contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Red, BlendMode.SrcIn)
            )
            Text(modifier = Modifier.fillMaxWidth(size.value),
                text = "FAILED",
            textAlign = TextAlign.Center)
    }
}