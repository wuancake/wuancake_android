package com.example.administrator.wuanandroid.Bean.StatusBean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Type
import java.util.ArrayList

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean.StatusBean
 * 文件名：   StatusRequestBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-20:31
 * 描述：
 */

class StatusRequestBean {

    /**
     * id : 1
     */

    var id: Int = 0

    companion object {

        fun objectFromData(str: String): StatusRequestBean {

            return Gson().fromJson(str, StatusRequestBean::class.java)
        }

        fun objectFromData(str: String, key: String): StatusRequestBean? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), StatusRequestBean::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayStatusRequestBeanFromData(str: String): List<StatusRequestBean>? {

            val listType = object : TypeToken<ArrayList<StatusRequestBean>>() {

            }.type

            return Gson().fromJson<List<StatusRequestBean>>(str, listType)
        }

        fun arrayStatusRequestBeanFromData(str: String, key: String): List<StatusRequestBean>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<StatusRequestBean>>() {

                }.type

                return Gson().fromJson<List<StatusRequestBean>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
