package com.example.administrator.wuanandroid.localAPI;

import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean;
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.Response;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.localAPI
 * 文件名：   SeeWeek
 * 创建者:    Nixo
 * 创建时间：  2018/4/5/005-13:32
 * 描述：
 */

public interface SeeWeek {

    @Headers({"Content-type:application/json;charset=utf-8","Accept:application/json"})
    @POST("/myweekly")
    Call<Response> seeWeek(@Body RequestBody route);

}
