package com.example.gpmass.di.module

import android.content.Context
import androidx.room.Room
import com.example.gpmass.room.dao.NoteDao
import com.example.gpmass.room.db.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): NotesDataBase{
        return Room.databaseBuilder(
            appContext,
            NotesDataBase::class.java,
            "GpMassDB"
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideGsDataDao(notesDataBase: NotesDataBase): NoteDao {
        return notesDataBase.noteDao()
    }
}