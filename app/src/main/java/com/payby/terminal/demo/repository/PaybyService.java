package com.payby.terminal.demo.repository;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaybyService {

    @POST("/pos-gateway/gateway.do")
    Call<Object> gatewayService(@Body RequestBody requestBody);

    @POST("/pos-gateway/device.do/")
    Call<Object> deviceService(@Body RequestBody requestBody);
}
