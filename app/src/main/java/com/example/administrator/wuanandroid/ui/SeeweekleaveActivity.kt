package com.example.administrator.wuanandroid.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.wuanandroid.R
import kotlinx.android.synthetic.main.item_seeweek_leave.*

class SeeweekleaveActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_seeweek_leave)
        var intent = getIntent()
        var i = intent.getIntExtra("status",3)

        if(i == 3){
            seeweek_leave_text.text = "本周已请假"
        }else if(i == 1){
            seeweek_leave_text.text = "本周未提交周报"
        }


        seeweek_leave_back.setOnClickListener { finish() }
    }
}
