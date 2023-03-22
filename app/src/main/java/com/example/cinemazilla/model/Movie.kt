package com.example.cinemazilla.model

import androidx.room.ColumnInfo
import androidx.room.Entity

data class Movie(
    val films: List<Film>
)

@Entity
data class Film(
    @ColumnInfo(name = "age_rating")
    val ageRating: List<AgeRating>,
    @ColumnInfo(name = "film_id")
    val filmId: Int,
    @ColumnInfo(name = "film_name")
    val filmName: String,
    @ColumnInfo(name = "film_trailer")
    val filmTrailer: String,
    val images: Images,
    @ColumnInfo(name = "imdb_id")
    val imdbId: Int,
    @ColumnInfo(name = "imdb_title_id")
    val imdbTitleId: String,
    @ColumnInfo(name = "other_titles")
    val otherTitles: String,
    @ColumnInfo(name = "release_dates")
    val releaseDates: List<ReleaseDate>,
    @ColumnInfo(name = "synopsis_long")
    val synopsisLong: String
)

data class Status(
    val count: Int,
    val device_datetime_sent: String,
    val device_datetime_used: String,
    val message: Any,
    val method: String,
    val request_method: String,
    val state: String,
    val territory: String,
    val version: String
)

data class AgeRating(
    val age_advisory: String,
    val age_rating_image: String,
    val rating: String
)

data class Images(
    val poster: Poster,
    val still: Still
)

data class ReleaseDate(
    val notes: String,
    val release_date: String
)

data class Poster(
    val `1`: X1
)

data class Still(
    val `1`: X1X
)

data class X1(
    val image_orientation: String,
    val medium: Medium,
    val region: String
)

data class Medium(
    val film_image: String,
    val height: Int,
    val width: Int
)

data class X1X(
    val image_orientation: String,
    val medium: Medium
)