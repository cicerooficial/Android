package com.senac.cicero.cardviewapplication.api;

import com.senac.cicero.cardviewapplication.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiProduto {

    @GET("/android/rest/produto")
    Call<List<Produto>> listarProduto();

}