package com.example.administrator.wuanandroids.Util.NetUtil.Request

import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.CancelBody
import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.GetCancel
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.AllGroup
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GetGroup
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GroupBody
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.GetIndex
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.IndexBody
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.GetLeave
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.LeaveBody
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.GetLogin
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.GetMyWeekly
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.MyWeeklyBody
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.GetQuitUnit
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.QuitUnitBody
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.GetRegist
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.RegistBody
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.GetSubmit
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.SubmitBody
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.GetUpateName
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.UpdateNameBody
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.GetUpdatePwd
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.UpdatePwdBody

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Request {
    //我的周报
    @Headers(HEADER)
    @POST("myweekly")
    fun PostMyWeekly(@Body myWeeklyBody: MyWeeklyBody): Observable<GetMyWeekly>

    //退出分组
    @Headers(HEADER)
    @POST("quitGroup")
    fun PostQuitUnit(@Body quitUnitBody: QuitUnitBody): Observable<GetQuitUnit>

    //修改昵称
    @Headers(HEADER)
    @POST("updateUserName")
    fun PostUpdateName(@Body updateNameBody: UpdateNameBody): Observable<GetUpateName>

    //修改密码
    @Headers(HEADER)
    @POST("updatePassword")
    fun PostUpdatePwd(@Body updatePwdBody: UpdatePwdBody): Observable<GetUpdatePwd>

    //注册
    @Headers(HEADER)
    @POST("regist")
    fun PostRegist(@Body registBody: RegistBody): Observable<GetRegist>

    //登陆
    @Headers(HEADER)
    @POST("login")
    fun PostLogin(@Body loginBody: LoginBody): Observable<GetLogin>

    //分组
    @Headers(HEADER)
    @POST("group")
    fun PostGroup(@Body groupBody: GroupBody): Observable<GetGroup>

    //全部分组
    @Headers(HEADER)
    @POST("findAllGroupInfo")
    fun PostAllGroup(): Observable<AllGroup>

    //请假
    @Headers(HEADER)
    @POST("leave")
    fun PostLeave(@Body leaveBody: LeaveBody): Observable<GetLeave>

    //提交周报
    @Headers(HEADER)
    @POST("submit")
    fun PostSubmit(@Body submitBody: SubmitBody): Observable<GetSubmit>

    //首页
    @Headers(HEADER)
    @POST("main")
    fun PostIndex(@Body indexBody: IndexBody): Observable<GetIndex>

    //取消请假
    @Headers(HEADER)
    @POST("cancelLeave")
    fun PostCancel(@Body cancelBody: CancelBody): Observable<GetCancel>

    companion object {

        /**
         * 服务器BaseUrl
         */
        val URL = "http://13.125.249.52:8008/"
        const val HEADER = "Content-ype:application/json;charset=UTF-8"
    }
}
