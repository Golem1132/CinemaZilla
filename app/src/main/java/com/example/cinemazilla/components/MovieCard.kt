package com.example.cinemazilla.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.cinemazilla.model.Film

//"https://images.unsplash.com/photo-1674574124473-e91fdcabaefc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
private val imageModifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(0.8f)
    .clip(RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10))

@Composable
fun LargeMovieCard(item: Film) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(400.dp)
            .clickable {

            },
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SubcomposeAsyncImage(
            modifier = imageModifier,
            model = item.images.poster.`1`.medium.film_image,
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .aspectRatio(1f, true)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = item.film_name ?: "",
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun SmallMovieCard() {
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .clickable {

            }
    ) {
        SubcomposeAsyncImage(
            modifier = imageModifier,
            model = "https://images.unsplash.com/photo-1674574124473-e91fdcabaefc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8",
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .aspectRatio(1f, true)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }

        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE TITLE ",
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis
        )
    }
}
