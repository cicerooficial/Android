package com.example.retrofitcep.retrofit;

import com.example.retrofitcep.api.ApiCep;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiCep getCEPService() {
        return this.retrofit.create(ApiCep.class);
    }

}
