package com.example.administrator.wuanandroid.localAPI

import com.example.administrator.wuanandroid.Bean.CancelLeaveBean.CancelResponse
import com.example.administrator.wuanandroid.Bean.GroupBean.AllGroupBean
import com.example.administrator.wuanandroid.Bean.GroupBean.GroupResponse
import com.example.administrator.wuanandroid.Bean.LeaveBean.LeaveResponse
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean
import com.example.administrator.wuanandroid.Bean.RegisterBean.RegisterResponse
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekResponse
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusBean
import com.example.administrator.wuanandroid.Bean.setNewsBean.SetNewsResponse

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Nixo on 25/05/2018.
 */

interface IApi {


    //登陆
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/login")
    fun login(@Body LoginBody: RequestBody): Observable<LoginResultBean>

    //主页
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/main")
    fun IStatus(@Body id: RequestBody): Observable<StatusBean>

    //查看周报
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/myweekly")
    fun ISeeWeek(@Body route: RequestBody): Observable<SeeWeekResponse>

    //提交周报
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/submit")
    fun ISetWeekNews(@Body route: RequestBody): Observable<SetNewsResponse>

    //注册账号
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/regist")
    fun IRegister(@Body route: RequestBody): Observable<RegisterResponse>

    //选择分组
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/group")
    fun IGroup(@Body route: RequestBody): Observable<GroupResponse>

    //请假
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/leave")
    fun ILeave(@Body route: RequestBody): Observable<LeaveResponse>


    //请假
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/cancelLeave")
    fun ICanceLeave(@Body route: RequestBody): Observable<CancelResponse>

    //获取全部分组
    @GET("/findAllGroupInfo")
    fun getAllGroup(): Observable<AllGroupBean>

}
