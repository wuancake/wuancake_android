package com.example.administrator.wuanandroid.Bean.StatusBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.StatusBean
 * 文件名：   StatusBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-20:20
 * 描述：
 */

public class StatusBean {


    /**
     * weekNum : 117
     * status : 0
     * infoText : 重定向
     * infoCode : 301
     * url : /main
     */

    private int weekNum;
    private String status;
    private String infoText;
    private int infoCode;
    private String url;

    public static StatusBean objectFromData(String str) {

        return new Gson().fromJson(str, StatusBean.class);
    }

    public static StatusBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), StatusBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<StatusBean> arrayStatusBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<StatusBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<StatusBean> arrayStatusBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<StatusBean>>() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
