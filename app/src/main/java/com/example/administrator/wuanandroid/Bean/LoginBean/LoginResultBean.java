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
 * 文件名：   LoginResultBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-20:22
 * 描述：      登陆返回Bean
 */

public class LoginResultBean {
    /**
     * infoText : 登录成功未选择分组
     * infoCode : 200
     * user_id : 10
     * group_id : 0
     */

    private String infoText;
    private String infoCode;
    private int user_id;
    private int group_id;

    public static LoginResultBean objectFromData(String str) {

        return new Gson().fromJson(str, LoginResultBean.class);
    }

    public static LoginResultBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LoginResultBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<LoginResultBean> arrayLoginResultBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LoginResultBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<LoginResultBean> arrayLoginResultBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<LoginResultBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }


    /**
     * {
     "infoText":"登录成功未选择分组",
     "infoCode":"200",
     "user_id":10,
     "group_id":0
     }
     */


}
