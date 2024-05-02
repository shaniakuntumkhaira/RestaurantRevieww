package com.shania.tugas7.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiConfig {

    public static ApiService getApiService() {
        HttpLoggingInterceptor.Level logLevel = BuildConfig.DEBUG ?
        HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(logLevel);

        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://restaurant-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

        return retrofit.create(ApiService.class);
    }
}
