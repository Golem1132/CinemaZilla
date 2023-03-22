package com.example.cinemazilla.retrofit

import com.example.cinemazilla.BuildConfig
import com.example.cinemazilla.model.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CinemaZillaApi {
    @GET("filmsNowShowing/?n=10")
    fun getFilmsNowShowing(@Header("device-datetime") date: String): Call<Movie>
}