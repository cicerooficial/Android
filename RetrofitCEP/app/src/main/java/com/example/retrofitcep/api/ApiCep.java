package com.example.retrofitcep.api;

import com.example.retrofitcep.model.Cep;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiCep {

    @GET("{cep}/json")
    Call<Cep> buscarCEP(@Path("cep") String cep);

}
