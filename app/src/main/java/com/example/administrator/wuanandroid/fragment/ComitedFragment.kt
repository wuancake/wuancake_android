package com.example.administrator.wuanandroid.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.CountDownUtil
import com.example.administrator.wuanandroid.utils.StaticClass
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.fragment_commited.*
import kotlinx.android.synthetic.main.fragment_commited.view.*
import kotlinx.android.synthetic.main.fragment_leave.view.*

import org.joda.time.DateTime
import org.joda.time.Interval
import org.joda.time.Period
import java.util.concurrent.TimeUnit

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   ComitedFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:51
 * 描述：         已提交
 */

class ComitedFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_commited, container, false)
        var mComitedTimer = view.commited_timer
        CountDownUtil(StaticClass.TIMER_TIME,1000,mComitedTimer).start()
        return view
    }




}
