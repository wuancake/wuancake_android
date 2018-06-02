package com.example.administrator.wuanandroid.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.wuanandroid.R
import kotlinx.android.synthetic.main.fragment_leave.*

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   LeaveFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:52
 * 描述：
 */

class LeaveFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_leave, container, false)
        leave_csv.setStopTime(java.lang.Long.valueOf("604810500"))
        cancel_Leave.setOnClickListener {}//todo 取消周报
        return view
    }
}
