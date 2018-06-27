package com.example.administrator.wuanandroid.utils

import com.example.administrator.wuanandroid.localAPI.IApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.example.administrator.wuanandroid.utils.StaticClass.WUAN_URL

/**
 * Created by Nixo on 25/05/2018.
 */

object RequestUtil {

    val observable: IApi
        get() {
            val retrofit = Retrofit.Builder()
                    .baseUrl(StaticClass.WUAN_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(IApi::class.java)
        }
}
