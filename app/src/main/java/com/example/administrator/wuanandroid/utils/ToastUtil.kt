package com.example.administrator.wuanandroid.utils

import android.content.Context
import android.widget.Toast

class ToastUtil( context : Context) {

    var context = context

    fun lt(text : String? ):Unit{
        Toast.makeText(context,text,Toast.LENGTH_LONG)
    }

    fun st(text : String? ):Unit{
        Toast.makeText(context,text,Toast.LENGTH_SHORT)
    }
}