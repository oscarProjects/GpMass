package com.example.gpmass.di.module

import com.example.gpmass.retrofit.ApiRetrofit
import com.example.gpmass.retrofit.ClientRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiRetrofit? {
        return ClientRetrofit.getApiRetrofit(ClientRetrofit.getRetrofitInstance())
    }
}