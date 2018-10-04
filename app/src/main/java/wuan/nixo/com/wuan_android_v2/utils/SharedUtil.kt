package wuan.nixo.com.wuan_android_v2.utils

import android.content.Context
import android.content.SharedPreferences


import wuan.nixo.com.wuan_android_v2.Common.StaticClass.NAME

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.utils
 * 文件名：   SharedUtil
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-19:56
 * 描述：      SharedPreferneces封装类
 */

class SharedUtil {


    fun putString(mContext: Context, key: String, value: String) {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sp.edit().putString(key, value).commit()
    }

    fun getString(mContext: Context, key: String, deafValue: String): String? {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sp.getString(key, deafValue)
    }

    fun putInt(mContext: Context, key: String, value: Int) {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sp.edit().putInt(key, value).commit()
    }

    fun getInt(mContext: Context, key: String, deafValue: Int): Int {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sp.getInt(key, deafValue)
    }

    fun putBoolean(mContext: Context, key: String, value: Boolean) {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sp.edit().putBoolean(key, value)
    }

    fun getBoolean(mContext: Context, key: String, deafVale: Boolean): Boolean {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(key, deafVale)
    }

    fun delShared(mContext: Context, key: String) {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sp.edit().remove(key)
    }

    fun delALL(mContext: Context) {
        var sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sp.edit().clear()
    }


}