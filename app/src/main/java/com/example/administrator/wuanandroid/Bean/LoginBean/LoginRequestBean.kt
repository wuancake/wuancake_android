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
 * 文件名：   LoginRequestBean
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-20:21
 * 描述：      登陆请求Bean；
 */

class LoginRequestBean {


    /**
     * email : 894144874@qq.com
     * password : 123456
     */

    var email: String? = null
    var password: String? = null

    companion object {

        fun objectFromData(str: String): LoginRequestBean {

            return Gson().fromJson(str, LoginRequestBean::class.java)
        }

        fun objectFromData(str: String, key: String): LoginRequestBean? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), LoginRequestBean::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayLoginRequestBeanFromData(str: String): List<LoginRequestBean>? {

            val listType = object : TypeToken<ArrayList<LoginRequestBean>>() {

            }.type

            return Gson().fromJson<List<LoginRequestBean>>(str, listType)
        }

        fun arrayLoginRequestBeanFromData(str: String, key: String): List<LoginRequestBean>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<LoginRequestBean>>() {

                }.type

                return Gson().fromJson<List<LoginRequestBean>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
