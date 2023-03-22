package com.example.cinemazilla.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api-gate2.movieglu.com/"

val httpClient = OkHttpClient.Builder()
    .addInterceptor(CustomInterceptor())

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(httpClient.build())
    .build()


val api: CinemaZillaApi by lazy {
    retrofit.create(CinemaZillaApi::class.java)
}
