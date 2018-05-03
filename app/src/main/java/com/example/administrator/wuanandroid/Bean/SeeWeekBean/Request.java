package com.example.administrator.wuanandroid.Bean.SeeWeekBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.SeeWeekBean
 * 文件名：   Request
 * 创建者:    Nixo
 * 创建时间：  2018/4/5/005-13:35
 * 描述：
 */

public class Request {


    /**
     * userId : 1
     * weekNum : 117
     */

    private int userId;
    private int weekNum;

    public static Request objectFromData(String str) {

        return new Gson().fromJson(str, Request.class);
    }

    public static Request objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Request.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Request> arrayRequestFromData(String str) {

        Type listType = new TypeToken<ArrayList<Request>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Request> arrayRequestFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Request>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }
}
