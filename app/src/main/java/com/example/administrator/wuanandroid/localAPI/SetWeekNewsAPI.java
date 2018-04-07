package com.example.administrator.wuanandroid.localAPI;

import com.example.administrator.wuanandroid.Bean.setNewsBean.Response;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.localAPI
 * 文件名：   SetWeekNewsAPI
 * 创建者:    Nixo
 * 创建时间：  2018/4/6/006-17:37
 * 描述：
 */

public interface SetWeekNewsAPI {


    @Headers({"Content-type:application/json;charset=utf-8","Accept:application/json"})
    @POST("/submit")
    Call<Response> SetWeekNews (@Body RequestBody route);
}
