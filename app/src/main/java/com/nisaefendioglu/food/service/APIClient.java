package com.nisaefendioglu.food.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "https://www.themealdb.com/api/";
    public static <Api> Api createService(Class<Api> serviceClass) {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient());
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}
