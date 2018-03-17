package com.example.administrator.wuanandroid.utils;

import android.util.Log;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.utils
 * 文件名：   LLog
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-19:52
 * 描述：      Log封装类
 */

public class L {

    public static boolean contril = true;
    public static String TAG ="WuAnLife";


    public void d(String text){
        if(contril){
            Log.d(TAG, text);
        }
    }


    public void i(String text){
        if(contril){
            Log.i(TAG, text);
        }
    }


    public void e(String text){
        if(contril){
            Log.e(TAG, text );
        }
    }

    public void w(String text){
        if(contril){
            Log.w(TAG, text);
        }
    }



}
