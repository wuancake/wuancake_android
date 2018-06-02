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
 * 文件名：   Request
 * 创建者:    Nixo
 * 创建时间：  2018/4/5/005-13:35
 * 描述：
 */

class SeeWeekRequest {


    /**
     * userId : 1
     * weekNum : 117
     */

    var userId: Int = 0
    var weekNum: Int = 0

    companion object {

        fun objectFromData(str: String): SeeWeekRequest {

            return Gson().fromJson(str, SeeWeekRequest::class.java)
        }

        fun objectFromData(str: String, key: String): SeeWeekRequest? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), SeeWeekRequest::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayRequestFromData(str: String): List<SeeWeekRequest>? {

            val listType = object : TypeToken<ArrayList<SeeWeekRequest>>() {

            }.type

            return Gson().fromJson<List<SeeWeekRequest>>(str, listType)
        }

        fun arrayRequestFromData(str: String, key: String): List<SeeWeekRequest>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<SeeWeekRequest>>() {

                }.type

                return Gson().fromJson<List<SeeWeekRequest>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
