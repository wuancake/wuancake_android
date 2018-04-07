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
 * 文件名：   Response
 * 创建者:    Nixo
 * 创建时间：  2018/4/5/005-13:41
 * 描述：
 */

public class Response {


    /**
     * weekNum : 117
     * complete : 削了XXX知识
     * trouble : 本周遇到的困难
     * plane : 下周准备学习xxx
     * url : http://github.com
     * infoText : 成功返回周报
     * infoCode : 200
     */

    private int weekNum;
    private String complete;
    private String trouble;
    private String plane;
    private String url;
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

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getTrouble() {
        return trouble;
    }

    public void setTrouble(String trouble) {
        this.trouble = trouble;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
