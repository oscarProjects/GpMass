package com.example.gpmass.retrofit;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiRetrofit {

    @POST
    Call<ResponseBody> post(@Url String url,
                                          @HeaderMap HashMap<String, String> headerMap,
                                          @Body HashMap<String, Object> bodyRequest);

    @GET
    Call<ResponseBody> get(@Url String url);
}
