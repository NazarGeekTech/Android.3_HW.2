package com.example.myandroid3home2.data.remote;

import com.example.myandroid3home2.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private RetrofitFactory() {}

    private static TerminApi instance;

    public static TerminApi getInstance() {
        if (instance == null) {
            instance = new  Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TerminApi.class);
        }
        return instance;
    }

}
