package com.example.administrator.wuanandroid.Bean.LoginBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean
 * 文件名：   LoginRequestBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-20:21
 * 描述：      登陆请求Bean；
 */

public class LoginRequestBean {


    /**
     * email : 894144874@qq.com
     * password : 123456
     */

    private String email;
    private String password;

    public static LoginRequestBean objectFromData(String str) {

        return new Gson().fromJson(str, LoginRequestBean.class);
    }

    public static LoginRequestBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LoginRequestBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<LoginRequestBean> arrayLoginRequestBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LoginRequestBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<LoginRequestBean> arrayLoginRequestBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<LoginRequestBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
