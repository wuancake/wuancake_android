package com.example.administrator.wuanandroids.Util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources

import com.example.administrator.wuanandroids.Tool.DensityHelper
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager

import java.util.ArrayList

class BaseApplication : Application() {
    private var allActivities: MutableList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        //网络管理工具单例初始化；
        NetWorkManager.getInstance().init()
        instance = this
        applContext = instance!!.applicationContext
        allActivities = ArrayList()
        DensityHelper(this, DESIGN_WIDTH.toFloat()).activate()

    }

    fun addActivity(act: Activity) {
        if (!allActivities!!.contains(act)) {
            allActivities!!.add(act)
        }
    }

    fun removeActiviy(act: Activity) {
        if (allActivities!!.contains(act)) {
            allActivities!!.remove(act)
            act.finish()
        }
    }

    fun exitApp() {
        for (activity in allActivities!!) {
            activity.finish()
        }
//        android.os.Process.killProcess(android.os.Process.myPid())
//        System.exit(0)
    }

    //设置字体为默认大小，不随系统字体大小改而改变
    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.fontScale != 1f)
        //非默认值
            resources
        super.onConfigurationChanged(newConfig)
    }


    override fun getResources(): Resources {
        val res = super.getResources()
        if (res.configuration.fontScale != 1f) {//非默认值
            val newConfig = Configuration()
            newConfig.setToDefaults()//设置默认
            res.updateConfiguration(newConfig, res.displayMetrics)
        }
        return res
    }

    companion object {

        @get:Synchronized
        var instance: BaseApplication? = null
            private set
        var applContext: Context? = null
            private set

        private val DESIGN_WIDTH = 720
    }
}
