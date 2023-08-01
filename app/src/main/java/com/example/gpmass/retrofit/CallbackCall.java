package com.example.gpmass.retrofit;

import com.google.gson.JsonElement;

public interface CallbackCall {
    void onSuccess(boolean isSuccessful, JsonElement data, JsonElement token);
    void onFailed(Throwable throwable);
}
