package com.example.administrator.wuanandroid.utils

import android.app.Activity

class ActivityCollector {

    var List = ArrayList<Activity>()

    fun addActivity(activity: Activity):Unit{
        List.add(activity)
    }

    fun removeActivity(activity: Activity):Unit{
        List.remove(activity)
    }

    fun finishAll():Unit{
        for(item in List){
            if(!item.isFinishing){
                item.finish()
            }
        }
        List.clear()
    }

}
