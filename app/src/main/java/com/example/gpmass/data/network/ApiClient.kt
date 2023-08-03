package com.example.gpmass.data.network

import com.example.gpmass.data.model.ResponseModel
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @GET
    suspend fun getAllNotes(@Url uri: String): Response<ResponseModel>?
}