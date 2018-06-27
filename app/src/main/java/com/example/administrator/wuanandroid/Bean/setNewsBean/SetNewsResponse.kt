package com.example.administrator.wuanandroid.Bean.setNewsBean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Type
import java.util.ArrayList

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.setNewsBean
 * 文件名：   Response
 * 创建者:    Nixo
 * 创建时间：  2018/4/6/006-17:36
 * 描述：
 */

class SetNewsResponse {


    /**
     * infoText  : 成功提交周报
     * infoCode  : 200
     */

    var infoText: String? = null
    var infoCode: Int = 0

    companion object {

        fun objectFromData(str: String): SetNewsResponse {

            return Gson().fromJson(str, SetNewsResponse::class.java)
        }

        fun objectFromData(str: String, key: String): SetNewsResponse? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), SetNewsResponse::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayResponseFromData(str: String): List<SetNewsResponse>? {

            val listType = object : TypeToken<ArrayList<SetNewsResponse>>() {

            }.type

            return Gson().fromJson<List<SetNewsResponse>>(str, listType)
        }

        fun arrayResponseFromData(str: String, key: String): List<SetNewsResponse>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<SetNewsResponse>>() {

                }.type

                return Gson().fromJson<List<SetNewsResponse>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
