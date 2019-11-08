package com.example.ru_itech.CommonUI.Api;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit;
    public static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit getClient(){
        if(retrofit== null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
