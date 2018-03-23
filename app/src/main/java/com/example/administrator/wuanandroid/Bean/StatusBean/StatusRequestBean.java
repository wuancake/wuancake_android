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
 * 文件名：   StatusRequestBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-20:31
 * 描述：
 */

public class StatusRequestBean {

    /**
     * id : 1
     */

    private int id;

    public static StatusRequestBean objectFromData(String str) {

        return new Gson().fromJson(str, StatusRequestBean.class);
    }

    public static StatusRequestBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), StatusRequestBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<StatusRequestBean> arrayStatusRequestBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<StatusRequestBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<StatusRequestBean> arrayStatusRequestBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<StatusRequestBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
