package wuan.nixo.com.wuan_android_v2.utils


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.support.multidex.MultiDexApplication
import android.util.Log

import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.cookie.CookieJarImpl
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore
import com.zhy.http.okhttp.log.LoggerInterceptor

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient



/**
 * Created by zhanghongyu on 2018/6/14.
 */

class App : MultiDexApplication() {

    @SuppressLint("MissingSuperCall")
    override fun onCreate() {


        okHttpInit()
    }

    /**
     * okHttp初始化
     */
    private fun okHttpInit() {
        val cookieJar = CookieJarImpl(PersistentCookieStore(applicationContext))
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(LoggerInterceptor("car"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)//cookie保活
                .build()

        OkHttpUtils.initClient(okHttpClient)
    }

    companion object {

        var mWidth: Int = 0
        var mheight: Int = 0
        var SHARE_NAME = "wuan"
        var TEL = "12345678"


        /**
         * 设置是否登录
         */


        //通过PackageInfo得到的想要启动的应用的包名
        private fun getPackageInfo(context: Context): PackageInfo? {
            var pInfo: PackageInfo? = null

            try {
                //通过PackageManager可以得到PackageInfo
                val pManager = context.packageManager
                pInfo = pManager.getPackageInfo(context.packageName,
                        PackageManager.GET_CONFIGURATIONS)

                return pInfo
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return pInfo
        }
    }
}
