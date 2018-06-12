package com.example.administrator.wuanandroid.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.wuanandroid.utils.ActivityCollector

open class BaseActivity : AppCompatActivity() {

    var  ac = ActivityCollector()

    override fun onCreate(savedInstanceState: Bundle, persistentState: PersistableBundle) {
        super.onCreate(savedInstanceState, persistentState)
        ac.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ac.removeActivity(this)
    }

    fun getac():ActivityCollector{
        return ac
    }

}