package com.example.cinemazilla.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val films: List<Film>
)

@Entity
data class Film(
    @ColumnInfo(name = "ageRating")
    val age_rating: List<AgeRating>?,
    @ColumnInfo(name = "filmId")
    @PrimaryKey(autoGenerate = false)
    val film_id: Int,
    @ColumnInfo(name = "filmName")
    val film_name: String?,
    @ColumnInfo(name = "filmTrailer")
    val film_trailer: String?,
    val images: Images,
    @ColumnInfo(name = "imdbId")
    val imdb_id: Int,
    @ColumnInfo(name = "imdbTitleId")
    val imdb_title_id: String?,
    @ColumnInfo(name = "otherTitles")
    val other_titles: String?,
    @ColumnInfo(name = "releaseDates")
    val release_dates: List<ReleaseDate>?,
    @ColumnInfo(name = "synopsisLong")
    val synopsis_long: String?
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