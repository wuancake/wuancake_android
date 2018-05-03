package com.example.administrator.wuanandroid;

import com.example.administrator.wuanandroid.response.RegisterResponse;
import com.example.administrator.wuanandroid.response.GroupingResponse;
import com.example.administrator.wuanandroid.response.LeaveResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ChijinLoujue on 2018/3/25.
 */

public interface UserApi {
    @POST("/regist")
    @FormUrlEncoded
    Call<RegisterResponse> register(@Field("user_name") String user_name, @Field("email") String email,
                                    @Field("QQ") String QQ, @Field("password") String password);

    @POST("/group")
    @FormUrlEncoded
    Call<GroupingResponse> grouping(@Field("user_id") int user_id, @Field("group_id") int group_id);

    @POST("/leave")
    @FormUrlEncoded
    Call<LeaveResponse> leave(@Field("userId") int user_id, @Field("week_num") int week_num,
                              @Field("reason") String reason);

}
