package com.example.gpmass.di.manager

import com.example.gpmass.retrofit.ApiRetrofit
import com.google.gson.JsonParser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RetrofitManager @Inject constructor(private val apiRetrofit: ApiRetrofit) {

    fun executePost(
        service: String?,
        headerMap: HashMap<String?, String?>?,
        bodyRequest: HashMap<String?, Any?>?
    ) {
        val call: Call<ResponseBody> = apiRetrofit.post(service, headerMap, bodyRequest)
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                if (response.isSuccessful && response.body() != null) {
                    try {
                        val jsonElement = JsonParser().parse(response.body()!!.string())
                        if (jsonElement.isJsonObject) {
                            /*callbackCall.onSuccess(
                                true, jsonElement.asJsonObject["data"],
                                jsonElement.asJsonObject["access_token"]
                            )*/
                        } else {
                            //callbackCall.onSuccess(true, null, null)
                        }
                    } catch (e: IOException) {
                        throw RuntimeException(e)
                    }
                } else {
                    try {
                        if (response.body() != null) {
                            val jo = JsonParser().parse(response.body()!!.string()).asJsonObject
                            //callbackCall.onSuccess(false, jo["message"], jo["errors"])
                        }
                    } catch (e: IOException) {
                        throw RuntimeException(e)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                //callbackCall.onFailed(t)
            }
        })
    }
}
