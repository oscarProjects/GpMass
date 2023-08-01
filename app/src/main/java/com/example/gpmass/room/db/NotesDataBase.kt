package com.example.gpmass.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gpmass.room.dao.NoteDao
import com.example.gpmass.room.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}