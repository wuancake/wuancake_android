package com.example.administrator.wuanandroid.Util.NetUtil.Request;

import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Request {

    /**
     * 服务器BaseUrl
     */
    public final String URL="http://13.125.249.52:8080/";
    public static final String HEADER="Content-type:application/json;charset=UTF-8";
    //我的周报
    @Headers(HEADER)
    @POST("myweekly")
    Observable<Response<List<GetMyWeekly>>> PostMyWeekly(@Body MyWeeklyBody myWeeklyBody);

    //退出分组
    @Headers(HEADER)
    @POST("quitGroup")
    Observable<Response<List<GetQuitUnit>>> PostQuitUnit(@Body QuitUnitBody quitUnitBody);

    //修改昵称
    @Headers(HEADER)
    @POST("updateUserName")
    Observable<Response<List<GetUpateName>>> PostUpdateName(@Body UpdateNameBody updateNameBody);

    //修改密码
    @Headers(HEADER)
    @POST("updatePassword")
    Observable<Response<List<GetUpdatePwd>>> PostUpdatePwd(@Body UpdatePwdBody updatePwdBody);

}
