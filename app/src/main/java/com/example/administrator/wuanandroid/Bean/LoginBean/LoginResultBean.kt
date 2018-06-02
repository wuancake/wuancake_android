package com.example.administrator.wuanandroid.Bean.LoginBean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Type
import java.util.ArrayList

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.Bean
 * 文件名：   LoginResultBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-20:22
 * 描述：      登陆返回Bean
 */

class LoginResultBean {
    /**
     * infoText : 登录成功未选择分组
     * infoCode : 200
     * user_id : 10
     * group_id : 0
     */

    var infoText: String? = null
    var infoCode: String? = null
    var user_id: Int = 0
    var group_id: Int = 0

    companion object {

        fun objectFromData(str: String): LoginResultBean {

            return Gson().fromJson(str, LoginResultBean::class.java)
        }

        fun objectFromData(str: String, key: String): LoginResultBean? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), LoginResultBean::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayLoginResultBeanFromData(str: String): List<LoginResultBean>? {

            val listType = object : TypeToken<ArrayList<LoginResultBean>>() {

            }.type

            return Gson().fromJson<List<LoginResultBean>>(str, listType)
        }

        fun arrayLoginResultBeanFromData(str: String, key: String): List<LoginResultBean>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<LoginResultBean>>() {

                }.type

                return Gson().fromJson<List<LoginResultBean>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }


    /**
     * {
     * "infoText":"登录成功未选择分组",
     * "infoCode":"200",
     * "user_id":10,
     * "group_id":0
     * }
     */


}
