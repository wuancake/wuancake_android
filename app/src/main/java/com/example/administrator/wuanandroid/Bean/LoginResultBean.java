package com.example.administrator.wuanandroid.Bean;

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
     * userId : 1
     * groupId : 7
     * infoText : 重定向
     * infoCode : 301
     * url : /main
     */

    private String userId;
    private int groupId;
    private String infoText;
    private String infoCode;
    private String url;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
