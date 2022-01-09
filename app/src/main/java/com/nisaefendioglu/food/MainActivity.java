package com.nisaefendioglu.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.os.Bundle;
import android.util.Log;

import com.nisaefendioglu.food.model.Meals;
import com.nisaefendioglu.food.service.APIClient;
import com.nisaefendioglu.food.service.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIService apiService;
    List<Meals.Items> MealsList = new ArrayList<>();
    Adapter adapter;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);

        adapter = new com.nisaefendioglu.food.adapter.Adapter(this, MealsList);
        recyclerview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);

        rec();
    }

    private void rec(){
        apiService = APIClient.createService(APIService.class);
        Call<Meals> call = apiService.getMenu();
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
               MealsList.addAll(response.body().getItemsList());
               adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<com.nisaefendioglu.food.model.Meals> call, Throwable t) {
                Log.d("TEST-1002", t.getMessage());
            }
        });
    }


}