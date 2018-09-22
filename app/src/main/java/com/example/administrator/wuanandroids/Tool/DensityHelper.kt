package com.example.administrator.wuanandroids.Tool

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.util.TypedValue
import android.view.WindowManager

import android.content.Context.WINDOW_SERVICE

/**
 * @class name: DensityHelper
 * @anthor ：卫士
 * @time :Create on 2018/9/18  12:59
 */
class DensityHelper
/**
 *
 * @param application
 * @param width 设计稿宽度
 */
(private val mApplication: Application, width: Float) {


    private val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
    private var designWidth = 720f

    init {
        designWidth = width

        activityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                //通常情况下application与activity得到的resource虽然不是一个实例，但是displayMetrics是同一个实例，只需调用一次即可
                //为了面对一些不可预计的情况以及向上兼容，分别调用一次较为保险
                resetDensity(mApplication, designWidth)
                resetDensity(activity, designWidth)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        }
    }

    /**
     * 激活本方案
     */
    fun activate() {
        resetDensity(mApplication, designWidth)
        mApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }

    /**
     * 恢复系统原生方案
     */
    fun inactivate() {
        restoreDensity(mApplication)
        mApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }

    companion object {

        /**
         * 重新计算displayMetrics.xhdpi, 使单位pt重定义为设计稿的相对长度
         * @see .activate
         * @param context
         * @param designWidth 设计稿的宽度
         */
        private fun resetDensity(context: Context, designWidth: Float) {
            val size = Point()
            (context.getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(size)

            context.resources.displayMetrics.xdpi = size.x / designWidth * 72f
        }

        /**
         * 恢复displayMetrics为系统原生状态，单位pt恢复为长度单位磅
         * @see .inactivate
         * @param context
         */
        private fun restoreDensity(context: Context) {
            context.resources.displayMetrics.setToDefaults()
        }

        /**
         * 转换dp为px
         * @param context
         * @param value 需要转换的dp值
         * @return
         */
        fun dp2px(context: Context, value: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics)
        }

        /**
         * 转换pt为px
         * @param context
         * @param value 需要转换的pt值，若context.resources.displayMetrics经过resetDensity()的修改则得到修正的相对长度，否则得到原生的磅
         * @return
         */
        fun pt2px(context: Context, value: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, value, context.resources.displayMetrics)
        }
    }


}
