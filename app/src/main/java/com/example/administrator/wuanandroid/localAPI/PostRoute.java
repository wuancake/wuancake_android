package com.example.administrator.wuanandroid.localAPI;

import com.example.administrator.wuanandroid.Bean.LoginResultBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.localAPI
 * 文件名：   PostRoute
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-20:10
 * 描 述：     Retrfit的Post接口
 */

public interface PostRoute {


    @Headers({"Content-type:application/json;charset=utf-8","Accept:application/json"})
    @POST("/login")
    Call<LoginResultBean> login(@Body RequestBody route);

}
