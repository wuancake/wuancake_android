package com.example.administrator.wuanandroid.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.mView.WaveViewByBezier
import com.example.administrator.wuanandroid.ui.LeaveActivity
import com.example.administrator.wuanandroid.ui.WriteActivity
import com.example.administrator.wuanandroid.utils.CountDownUtil
import com.example.administrator.wuanandroid.utils.L
import com.example.administrator.wuanandroid.utils.SharedUtil
import com.example.administrator.wuanandroid.utils.StaticClass
import kotlinx.android.synthetic.main.fragment_commitnt.*
import kotlinx.android.synthetic.main.fragment_commitnt.view.*

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
    val sharedUtil = SharedUtil()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_commitnt, container, false)
        var mComitntTimer = view.commitnt_timer
        CountDownUtil(StaticClass.TIMER_TIME,1000,mComitntTimer).start()
        var commit = view.commitnt_Commit
        var commitLeave = view.commitnt_Leave
        var Commitnt_Week = view.commitnt_Week
        Commitnt_Week.text = sharedUtil.getInt(this!!.activity!!,StaticClass.WEEK_NUM,1).toString()+"周"
        commit.setOnClickListener {startActivity(Intent(activity, WriteActivity::class.java)) } // 跳转到提交周报
        commitLeave.setOnClickListener {startActivity(Intent(activity,LeaveActivity::class.java))}// 跳转到请假


        return view
    }



}
