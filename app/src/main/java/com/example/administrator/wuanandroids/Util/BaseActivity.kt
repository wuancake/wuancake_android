package com.example.administrator.wuanandroids.Util

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.blankj.utilcode.util.BarUtils

import com.example.administrator.wuanandroids.Tool.AndroidWorkround
import com.example.administrator.wuanandroids.Tool.StatusBar
import com.githang.statusbar.StatusBarCompat

open class BaseActivity : AppCompatActivity() {
    private var oContext: BaseActivity? = null
    private var baseApplication: BaseApplication? = null
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        oContext = this
//   com.example.administrator.wuanandroids.Tool.BarUtils.setStatusBarColor(oContext!!,View(oContext), BLUE)
//         BarUtils.setStatusBarColor(this, BLACK,10,true)
//        StatusBarCompat.setStatusBarColor(oContext, BLACK)
//        StatusBarCompat.setStatusBarColor(this, BLACK,true)
//        if(status(oContext)==null) {
//           Log.d("ff",BarUtils.getStatusBarHeight().toString())
//        }
        //        Window window = getWindow();
        //        //设置虚拟键盘跟着屏幕自动
        //        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        //                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //        if (AndroidWorkround.checkDeviceHasNavigationBar(this)) {
        //            AndroidWorkround.assistActivity(findViewById(android.R.id.content));
        //        }
        BarUtils.setStatusBarColor(oContext!!, BLACK)
        if (baseApplication == null) {
            baseApplication = application as BaseApplication
        }

        addActivity()
    }

    // 添加Activity方法
    fun addActivity() {
        baseApplication!!.addActivity(this!!.oContext!!)// 调用myApplication的添加Activity方法
    }

    //销毁当个Activity方法
    fun removeActivity() {
        baseApplication!!.removeActiviy(this!!.oContext!!)// 调用myApplication的销毁单个Activity方法
    }

    //销毁所有Activity方法
    fun removeALLActivity() {
        baseApplication!!.exitApp()// 调用myApplication的销毁所有Activity方法
    }

    //自定义Toast
    fun show_Toast(text: String) {
        if (toast == null) {
            toast = Toast.makeText(oContext, text, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(text)
        }
        toast!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
    }

    companion object {
        val BLACK = Color.parseColor("#000000")
        val BLUE = Color.parseColor("#3195ff")
    }

//    fun status(activity:Activity?):View?{
//       var view: View? =null
//        if (activity != null) {
//             view=View(activity)
//        }
//
//        return view
//    }
}
