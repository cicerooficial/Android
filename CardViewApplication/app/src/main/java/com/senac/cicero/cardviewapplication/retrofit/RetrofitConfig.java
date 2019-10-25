package com.senac.cicero.cardviewapplication.retrofit;

import com.senac.cicero.cardviewapplication.api.ApiProduto;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://oficinacordova.azurewebsites.net/android/rest/produto/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiProduto getProduto() {
        return this.retrofit.create(ApiProduto.class);
    }

}
