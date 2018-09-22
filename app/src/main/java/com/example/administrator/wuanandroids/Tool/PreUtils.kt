package com.example.administrator.wuanandroids.Tool

import android.content.Context
import android.content.SharedPreferences

/**
 * sp工具类<br></br>
 *
 * 此工具类主要用来保存一些类似帐号密码的少量的数据
 */
object PreUtils {
    /**
     * 保存boolean变量的值
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    fun setBoolean(context: Context, key: String, value: Boolean?) {
        //获取sp对象并且创建sp文件
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        //上传数据到sp文件中
        if (value != null) {
            sp.edit().putBoolean(key, value).commit()
        }
    }

    /**
     * 从sp文件中获取之前保存的boolean数据
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值，如果通过键没有找到对应的值，就会返回默认值
     * @return
     */
    fun getBoolean(context: Context, key: String, defValue: Boolean?): Boolean {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        return sp.getBoolean(key, defValue!!)
    }

    /**
     * 保存String变量的值
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    fun setString(context: Context, key: String, value: String?) {
        //获取sp对象并且创建sp文件
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        //上传数据到sp文件中
        sp.edit().putString(key, value).commit()
    }

    /**
     * 从sp文件中获取之前保存的String数据
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值，如果通过键没有找到对应的值，就会返回默认值
     * @return
     */
    fun getString(context: Context, key: String, defValue: String?): String? {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        return sp.getString(key, defValue)
    }


    //存int类型数据
    fun setInt(context: Context, key: String, value: Int?) {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        if (value != null) {
            sp.edit().putInt(key, value).commit()
        }
    }

    //获取int类型数据
    fun getInt(context: Context, key: String, defValue: Int?): Int {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        return sp.getInt(key, defValue!!)
    }

    //清除数据
    fun clears(context: Context?) {
        val sp = context!!.getSharedPreferences("data", Context.MODE_PRIVATE)
        sp.edit().clear().commit()
    }
}
