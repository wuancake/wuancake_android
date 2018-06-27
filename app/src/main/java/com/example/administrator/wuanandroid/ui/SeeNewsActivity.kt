package com.example.administrator.wuanandroid.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        var intent = getIntent()
        week_over.setText( intent.getStringExtra("1"))
        week_help.setText( intent.getStringExtra("2"))
        week_next.setText( intent.getStringExtra("3"))
        if(intent.getStringExtra("4") == null){
            url.setText("空")
        }else{
            url.setText( intent.getStringExtra("4"))
        }

        toolbar.title = intent.getStringExtra("5")






    }
}
