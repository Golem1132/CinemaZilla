package com.example.cinemazilla.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


private val imageModifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(0.7f)
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard() {
    Card(onClick = { /*TODO*/ }) {
        Column(modifier = Modifier
            .width(150.dp)
            .height(170.dp)) {
            Row(modifier = imageModifier,
            horizontalArrangement = Arrangement.Center) {
                SubcomposeAsyncImage(
                    modifier = Modifier.clip(RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10)),
                    model = "https://images.unsplash.com/photo-1674574124473-e91fdcabaefc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                    contentDescription = ""
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator()
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }
            }
            Text(text = "TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE ",
            maxLines = 2,
            softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
        }
        }

    }