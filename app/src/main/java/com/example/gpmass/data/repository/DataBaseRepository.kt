package com.example.gpmass.data.repository

import com.example.gpmass.room.dao.NoteDao
import com.example.gpmass.room.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataBaseRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun getData(): List<NoteEntity>{
        return withContext(Dispatchers.IO){
            noteDao.getListNotes()
        }
    }

    suspend fun saveData(noteEntity: NoteEntity){
        withContext(Dispatchers.IO){
            noteDao.insert(noteEntity)
        }
    }

    suspend fun deleteData(){
        withContext(Dispatchers.IO){
            noteDao.deleteAll()
        }
    }

}