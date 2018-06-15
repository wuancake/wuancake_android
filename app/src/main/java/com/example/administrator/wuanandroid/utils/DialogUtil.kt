package com.example.administrator.wuanandroid.utils

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.mView.mLoaddingDialog

class  DialogUtil (context :Context) {

    var context = context
    fun getLoaddingDialog (): Dialog{
        return mLoaddingDialog(context,300,300, R.layout.dialog_loadding, R.style.Dialog_Style, Gravity.CENTER, R.style.loadding_Style)
    }


}