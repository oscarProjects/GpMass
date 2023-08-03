package com.example.gpmass.data.network

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.di.manager.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(
    private val serviceManager: RetrofitManager
) {

    suspend fun getAllNotes() : ResponseModel {
        return withContext(Dispatchers.IO){
            val response = serviceManager.callServiceGetAllNotes("todos/1")
            response?.body()!!
        }
    }
}