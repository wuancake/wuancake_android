package com.example.administrator.wuanandroid.localAPI;

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
 * 文件名：   MainStatusLocal
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-20:39
 * 描述：
 */

public interface MainStatusLocal {



    /**
     * 首页：
     需要先判断本周，该用户是否已经提交了周报，如果已提交则跳转到提交周报成功的页面，否则显示距离本周结束倒计时
     POST /main

     请求格式：JSON 
     {
     "id":1,//用户id
     }

     响应成功（已提交周报）：JSON 
     {
     "status": "1",
     “infoText”:”重定向”,
     “infoCode”:”200”,
     }
     *
     */



    @Headers({"Content-type:application/json;charset=utf-8","Accept:application/json"})
    @POST("/main")
    Call<StatusBean> status(@Body RequestBody id);


}
