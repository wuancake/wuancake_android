package com.example.administrator.wuanandroid.ui

import android.app.Fragment
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.fragment.Fragment_Saved
import com.example.administrator.wuanandroid.fragment.Fragment_SetFail
import com.example.administrator.wuanandroid.fragment.Fragment_SetSuccessful
import com.example.administrator.wuanandroid.utils.StaticClass

class SavedActivity : AppCompatActivity() {


    internal var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) {
                startActivity(Intent(this@SavedActivity, MainActivity::class.java))
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)
        val intent = intent
        //1为保存成功
        // 2为提交成功
        // 3为提交失败，
        when(intent.extras.getInt(StaticClass.IS_UPDATANEEWS_KEY)){
            1 ->replaceFragent(Fragment_Saved())
            2->replaceFragent(Fragment_SetSuccessful())
            3->replaceFragent(Fragment_SetFail())
        }
        timeTread().start()
    }

    private fun replaceFragent(fragment: android.support.v4.app.Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.mFragment, fragment)
        transaction.commit()
    }

    internal inner class timeTread : Thread() {
        override fun run() {
            super.run()
            try {
                Thread.sleep(4000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            val message = handler.obtainMessage()
            message.what = 1
            handler.sendMessage(message)
        }
    }
}
