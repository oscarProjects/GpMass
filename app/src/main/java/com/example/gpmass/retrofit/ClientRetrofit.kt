package com.example.gpmass.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {
    private val httpClient = OkHttpClient.Builder()
    lateinit var client: OkHttpClient

    fun getClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(interceptor)

        client = httpClient.build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.1.89:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}