package com.nisaefendioglu.food.service;

import com.nisaefendioglu.food.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("json/v1/1/search.php?f=c")
    Call<Meals> getMenu();

    @GET("search.php")
    Call<Meals> searchMeal(@Query("s") String query);

}
