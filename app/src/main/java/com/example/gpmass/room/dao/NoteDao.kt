package com.example.gpmass.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gpmass.room.entities.NoteEntity
import java.util.*

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(noteEntity: NoteEntity)

    @Delete
    suspend fun delete(vararg noteEntity: NoteEntity)

    @Query("SELECT * FROM " + NoteEntity.TABLE_NAME)
    suspend fun getListNotes(): List<NoteEntity>

    @Query("DELETE FROM "+NoteEntity.TABLE_NAME)
    suspend fun deleteAll()
}