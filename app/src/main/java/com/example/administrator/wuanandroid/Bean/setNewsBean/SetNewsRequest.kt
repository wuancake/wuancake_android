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
 * 文件名：   Request
 * 创建者:    Nixo
 * 创建时间：  2018/4/6/006-17:35
 * 描述：
 */

class SetNewsRequest {

    /**
     * userId : 1
     * groupId : 1
     * complete : 本周完成的任务<br></br>
     * trouble : 本周遇到的困难<br></br>
     * plane : 下周的计划<br></br>
     * url : 作品链接
     */

    var userId: Int = 0
    var groupId: Int = 0
    var complete: String? = null
    var trouble: String? = null
    var plane: String? = null
    var url: String? = null

    companion object {

        fun objectFromData(str: String): SetNewsRequest {

            return Gson().fromJson(str, SetNewsRequest::class.java)
        }

        fun objectFromData(str: String, key: String): SetNewsRequest? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), SetNewsRequest::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayRequestFromData(str: String): List<SetNewsRequest>? {

            val listType = object : TypeToken<ArrayList<SetNewsRequest>>() {

            }.type

            return Gson().fromJson<List<SetNewsRequest>>(str, listType)
        }

        fun arrayRequestFromData(str: String, key: String): List<SetNewsRequest>? {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<SetNewsRequest>>() {

                }.type

                return Gson().fromJson<List<SetNewsRequest>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
