package com.example.cinemazilla.retrofit

import com.example.cinemazilla.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("client", BuildConfig.CLIENT)
            .header("x-api-key", BuildConfig.API_KEY)
            .header("authorization", BuildConfig.AUTHORIZATION)
            .header("territory","XX")
            .header("api-version","v200")
            .build()
        return  chain.proceed(request)
    }
}