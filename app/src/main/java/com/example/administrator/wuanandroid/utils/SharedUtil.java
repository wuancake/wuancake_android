package com.example.administrator.wuanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static com.example.administrator.wuanandroid.utils.StaticClass.NAME;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.utils
 * 文件名：   SharedUtil
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-19:56
 * 描述：      SharedPreferneces封装类
 */

public class SharedUtil  {



    public static void putString(Context mContext , String key , String value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context mContext , String key , String deafValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,deafValue);
    }

    public static void putInt(Context mContext , String  key , int  value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context mContext , String key , int deafValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,deafValue);
    }

    public static void putBoolean(Context mContext , String key ,Boolean value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value);
    }

    public static Boolean getBoolean(Context mContext , String key ,Boolean deafVale){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,deafVale);
    }

    public static void delShared(Context mContext , String key){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key);
    }

    public static void delALL(Context mContext){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear();
    }





}
