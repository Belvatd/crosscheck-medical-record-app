package com.app.architecture.client;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientService {

    @GET("temp")
    Call<Object> sendRequest();
}