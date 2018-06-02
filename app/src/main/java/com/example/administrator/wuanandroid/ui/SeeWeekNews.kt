package com.example.administrator.wuanandroid.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekRequest
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.L
import com.example.administrator.wuanandroid.utils.RequestUtil
import com.example.administrator.wuanandroid.utils.SharedUtil
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_see_week_news.*


class SeeWeekNews : AppCompatActivity() {


    var week: String? = null
    internal var util = SharedUtil()
    internal var l = L()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_week_news)
        initView()
        to_See.setOnClickListener { View -> RequestToSeeWeekNews() }

    }

    private fun initView() {
        val manager = LinearLayoutManager(this)
        seeWeek_RecyclerView.layoutManager = manager
    }

    private fun RequestToSeeWeekNews() {

        val request = SeeWeekRequest()
        val route = StringBuilder()
        request.userId = Integer.parseInt(util.getString(this@SeeWeekNews, "UserId", "-1"))
        request.weekNum = Integer.parseInt(week)
        val gson = Gson()
        route.append(gson.toJson(request))
        RequestUtil.observable
                .ISeeWeek(route.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    SeeWeekResponse->
                    //todo 查看周报加载逻辑
                }

    }


}
