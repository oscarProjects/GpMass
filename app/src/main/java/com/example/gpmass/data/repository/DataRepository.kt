package com.example.gpmass.data.repository

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.data.network.ApiService
import com.example.gpmass.room.entities.NoteEntity
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val api: ApiService
){

    suspend fun saveNote(noteEntity: NoteEntity): ResponseModel {
        return api.saveNote(noteEntity);
    }

    suspend fun getAllNotes(): ResponseModel {
        return api.getAllNotes()
    }
}