package com.example.gpmass.data.repository

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.data.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val api: ApiService
){

    suspend fun getAllNotes(): ResponseModel {
        return api.getAllNotes()
    }
}