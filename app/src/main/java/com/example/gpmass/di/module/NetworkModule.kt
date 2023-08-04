package com.example.gpmass.di.module

import com.example.gpmass.data.network.ApiClient
import com.example.gpmass.di.manager.RetrofitManager
import com.example.gpmass.retrofit.ClientRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val clientRetrofit: ClientRetrofit = ClientRetrofit()

    @Singleton
    @Provides
    fun provideRetrofit(): RetrofitManager {
        return RetrofitManager(clientRetrofit.getClient().create(ApiClient::class.java))
    }
}