package com.example.weatherapi;

import com.example.weatherapi.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather")
    Call<Data> getListData(@Query("q")  String q,@Query("appid") String apiid);
}
