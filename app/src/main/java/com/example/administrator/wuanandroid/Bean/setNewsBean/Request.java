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
 * 文件名：   Request
 * 创建者:    Nixo
 * 创建时间：  2018/4/6/006-17:35
 * 描述：
 */

public class Request {

    /**
     * userId : 1
     * groupId : 1
     * complete : 本周完成的任务<br>
     * trouble : 本周遇到的困难<br>
     * plane : 下周的计划<br>
     * url : 作品链接
     */

    private int userId;
    private int groupId;
    private String complete;
    private String trouble;
    private String plane;
    private String url;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
}
