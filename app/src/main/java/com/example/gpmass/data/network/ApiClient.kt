package com.example.gpmass.data.network

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.room.entities.NoteEntity
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @GET
    suspend fun getAllNotes(@Url uri: String): Response<ResponseModel>?

    @POST
    suspend fun saveNote(@Url uri: String, @Body noteEntity: NoteEntity): Response<ResponseModel>?
}