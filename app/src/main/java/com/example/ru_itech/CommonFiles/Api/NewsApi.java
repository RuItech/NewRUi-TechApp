package com.example.ru_itech.CommonFiles.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

@GET("everything")
Call<News> getAllNews(@Query("q")String topic,@Query("apiKey")String apiKey);


}
