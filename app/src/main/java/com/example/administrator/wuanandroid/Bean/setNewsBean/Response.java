package com.example.administrator.wuanandroid.Bean.setNewsBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.setNewsBean
 * 文件名：   Response
 * 创建者:    Nixo
 * 创建时间：  2018/4/6/006-17:36
 * 描述：
 */

public class Response {


    /**
     * infoText  : 成功提交周报
     * infoCode  : 200
     */

    private String infoText;
    private int infoCode;

    public static Response objectFromData(String str) {

        return new Gson().fromJson(str, Response.class);
    }

    public static Response objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Response.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Response> arrayResponseFromData(String str) {

        Type listType = new TypeToken<ArrayList<Response>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Response> arrayResponseFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Response>>() {
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

    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }
}
