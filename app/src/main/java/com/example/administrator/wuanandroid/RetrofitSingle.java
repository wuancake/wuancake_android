package com.example.administrator.wuanandroid;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ChijinLoujue on 2018/4/11.
 */
//URL = "http://13.114.107.36:8008/
public class RetrofitSingle {
    private static final String URL = "http://13.114.107.36:8008";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
