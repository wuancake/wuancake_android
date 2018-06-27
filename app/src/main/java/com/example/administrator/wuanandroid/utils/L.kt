package com.example.administrator.wuanandroid.utils

import android.util.Log
import com.example.administrator.wuanandroid.utils.StaticClass

import com.example.administrator.wuanandroid.utils.StaticClass.TAG



/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.utils
 * 文件名：   LLog
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-19:52
 * 描述：      Log封装类
 */

class L {


    fun d(text: String) {
        if (contril) {
            Log.d(StaticClass.TAG, text)
        }
    }


    fun i(text: String) {
        if (contril) {
            Log.i(StaticClass.TAG, text)
        }
    }


    fun e(text: String) {
        if (contril) {
            Log.e(StaticClass.TAG, text)
        }
    }

    fun w(text: String) {
        if (contril) {
            Log.w(StaticClass.TAG, text)
        }
    }

    //Debug模式开关
    companion object {
        var contril = true
    }


}
