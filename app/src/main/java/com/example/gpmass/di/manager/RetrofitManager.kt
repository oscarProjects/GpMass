package com.example.gpmass.di.manager

import com.example.gpmass.data.network.ApiClient
import com.example.gpmass.data.model.ResponseModel
import retrofit2.Response

class RetrofitManager(var api: ApiClient) {

    suspend fun callServiceGetAllNotes(service: String): Response<ResponseModel>? {
        return api.getAllNotes(service)
    }
}
