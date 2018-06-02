package com.example.administrator.wuanandroid.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.ui.WriteActivity
import com.example.administrator.wuanandroid.utils.CountDownView
import com.example.administrator.wuanandroid.utils.L
import kotlinx.android.synthetic.main.fragment_commitnt.*

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   ComitntFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:52
 * 描述：      未提交
 */

class ComitntFragment : Fragment() {

    val l = L()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_commitnt, container, false)
        commitnt_csv.setStopTime(java.lang.Long.valueOf("604810500"))
        commitnt_Commit.setOnClickListener { startActivity(Intent(activity, WriteActivity::class.java))} //todo 跳转到提交周报
        commitnt_Leave.setOnClickListener {}//todo 跳转到请假
        return view!!
    }
}
