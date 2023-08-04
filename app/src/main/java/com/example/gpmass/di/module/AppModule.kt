package com.example.gpmass.di.module

import android.app.Application
import com.example.gpmass.di.manager.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideManagerView(app: Application): NavigationManager = NavigationManager(app)
}