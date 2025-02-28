package com.payby.terminal.demo.http;

import com.payby.terminal.demo.repository.PaybyService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitWrapper {
    private static Retrofit retrofit;

    private RetrofitWrapper() {}

    public static void initialize(String baseUrl) {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory.create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpWrapper.getOkHttpClient())
                .addConverterFactory(gsonConverterFactory)
                .addConverterFactory(scalarsConverterFactory)
                .build();
    }

    public static PaybyService createService() {
        if (retrofit == null) {
            throw new IllegalStateException("RetrofitWrapper not initialized");
        }
        return retrofit.create(PaybyService.class);
    }
}
