package com.example.administrator.wuanandroid.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekResponse
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.L
import kotlinx.android.synthetic.main.activity_see_news.*
import kotlinx.android.synthetic.main.content_xd.*

class SeeNewsActivity : AppCompatActivity() {

    var l  = L()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_news)
        setSupportActionBar(toolbar)
        week_over.isEnabled = false
        week_help.isEnabled = false
        week_next.isEnabled = false
        url.isEnabled = false
        write_back.setOnClickListener{finish()}
        var Strlist = ArrayList<String>()
        var intent = getIntent()
        var News= intent.getStringExtra("1")
        toolbar.title = intent.getStringExtra("2")
        var desc = News.split("<br>")


        if(desc.size == 0){
            week_over.setText("无")
            week_help.setText("无")
            url.setText("无")
            week_next.setText("无")
        }else if(desc.size == 1){
            week_over.setText(desc[0])
            week_help.setText("无")
            url.setText("无")
            week_next.setText("无")

        }else if(desc.size == 2){
            week_over.setText(desc[0])
            week_help.setText(desc[1])
            url.setText("无")
            week_next.setText("无")
        }else if(desc.size == 3){
            week_over.setText(desc[0])
            week_help.setText(desc[1])
            week_next.setText(desc[2])
            url.setText("无")
        }else if(desc.size == 4){
            week_over.setText(desc[0])
            week_help.setText(desc[1])
            week_next.setText(desc[2])
            url.setText(desc[3])
        }else{
            week_over.setText(desc[0])
            week_help.setText(desc[1])
            week_next.setText(desc[2])
            url.setText(desc[3])
        }



    }
}
