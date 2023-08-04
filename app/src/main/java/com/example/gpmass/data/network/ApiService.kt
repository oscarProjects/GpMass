package com.example.gpmass.data.network

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.di.manager.RetrofitManager
import com.example.gpmass.room.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(
    private val serviceManager: RetrofitManager
) {

    suspend fun saveNote(noteEntity: NoteEntity) : ResponseModel {
        return withContext(Dispatchers.IO){
            val response = serviceManager.callServicePostSaveNote("api/v1/add-note", noteEntity)
            response?.body()!!
        }
    }

    suspend fun getAllNotes() : ResponseModel {
        return withContext(Dispatchers.IO){
            val response = serviceManager.callServiceGetAllNotes("api/v1/all-notes")
            response?.body()!!
        }
    }
}