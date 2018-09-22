package com.example.administrator.wuanandroids

import android.content.Intent
import android.os.Bundle

import com.example.administrator.wuanandroids.Mvp.View.LoginActivity
import com.example.administrator.wuanandroids.Util.BaseActivity

/**
 * @class name: MainActivity
 * @anthor ：卫士
 * @time :Create on 2018/8/20  18:17
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
