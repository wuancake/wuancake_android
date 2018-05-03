package com.example.administrator.wuanandroid.localAPI;

import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean;
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusBean;
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusRequestBean;

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

    /**
     *  接口：登录功能：
            登录考勤系统。
            POST /login
        请求格式：JSON 
        {
        "email": "894144874@qq.com",
        "password": "123456"
        }

        响应成功：
        {
        “userId”:”1”//用户id，标识唯一的用户
        “groupId”:7   //分组id
        “infoText”:”重定向”,
        “infoCode”:”301”,
        “url”:”/main

         }
     */

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("/login")
    Call<LoginResultBean> login(@Body RequestBody route);




}
