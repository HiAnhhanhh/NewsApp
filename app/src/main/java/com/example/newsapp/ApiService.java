package com.example.newsapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder().create();


    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("top-headlines")
    Call<mainNews> getNews (@Query("country") String country,
                            @Query("pageSize") String pageSize,
                            @Query("apiKey")String apiKey);

    @GET("top-headlines")
    Call<mainNews> getCategoryNews (@Query("country") String country,
                            @Query("category") String category,
                            @Query("pageSize") String pageSize,
                            @Query("apiKey")String apiKey);
}
