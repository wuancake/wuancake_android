package com.example.administrator.wuanandroid.Bean.SeeWeekBean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Type
import java.util.ArrayList

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.SeeWeekBean
 * 文件名：   Response
 * 创建者:    Nixo
 * 创建时间：  2018/4/5/005-13:41
 * 描述：
 */

class SeeWeekResponse {


    /**
     * weekNum : 117
     * complete : 削了XXX知识
     * trouble : 本周遇到的困难
     * plane : 下周准备学习xxx
     * url : http://github.com
     * infoText : 成功返回周报
     * infoCode : 200
     */

    var weekNum: Int = 0
    var complete: String? = null
    var trouble: String? = null
    var plane: String? = null
    var url: String? = null
    var infoText: String? = null
    var infoCode: Int = 0

    companion object {

        fun objectFromData(str: String): SeeWeekResponse {

            return Gson().fromJson(str, SeeWeekResponse::class.java)
        }

        fun objectFromData(str: String, key: String): SeeWeekResponse? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), SeeWeekResponse::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayResponseFromData(str: String): List<SeeWeekResponse>? {

            val listType = object : TypeToken<ArrayList<SeeWeekResponse>>() {

            }.type

            return Gson().fromJson<List<SeeWeekResponse>>(str, listType)
        }

        fun arrayResponseFromData(str: String, key: String): List<SeeWeekResponse>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<SeeWeekResponse>>() {

                }.type

                return Gson().fromJson<List<SeeWeekResponse>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
