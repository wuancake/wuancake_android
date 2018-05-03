package com.example.administrator.wuanandroid;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChijinLoujue on 2018/3/30.
 */

public class UserBrean {

    /**
     * uname : String
     * email : String
     * qq : String
     * password : String
     */

    private String uname;
    private String email;
    private String qq;
    private String password;

    public static UserBrean objectFromData(String str) {

        return new Gson().fromJson(str, UserBrean.class);
    }

    public static UserBrean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), UserBrean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<UserBrean> arrayUserBreanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UserBrean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<UserBrean> arrayUserBreanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<UserBrean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
