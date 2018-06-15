package com.example.administrator.wuanandroid.ui

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.example.administrator.wuanandroid.Adapter.MainRecyClickListen
import com.example.administrator.wuanandroid.Adapter.SeeAdapter
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekReqeust
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekResponse

import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.*
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_see_week_news.*
import okhttp3.RequestBody


class SeeWeekNews : AppCompatActivity() ,MainRecyClickListen{


    override fun MainRecyClickListener(bean: SeeWeekResponse.ReportsBean) {
        if(bean.status == 2){
            var i = Intent(this@SeeWeekNews,SeeNewsActivity::class.java)
            i.putExtra("1",bean.complete)
            i.putExtra("2",bean.trouble)
            i.putExtra("3",bean.plane)
            i.putExtra("4",bean.url)
            i.putExtra("5",bean.weekNum)

            startActivity(i)
        }else if(bean.status == 3 || bean.status == 1){
            var intent2 = Intent(this@SeeWeekNews,SeeweekleaveActivity::class.java)
            intent2.putExtra("status",bean.status)
            startActivity(Intent(intent2))
        }

    }


    var list  = ArrayList<SeeWeekResponse.ReportsBean>()

    var util = SharedUtil()
    var l = L()
    var t = ToastUtil(this@SeeWeekNews)
    var sp = StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
    var dialog:Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_week_news)
        see_back.setOnClickListener { finish() }
        dialog = DialogUtil(this@SeeWeekNews).getLoaddingDialog()

        RequestToSeeWeekNews()



    }




    private fun RequestToSeeWeekNews() {
        dialog!!.show()
        dialog!!.setCancelable(false)
        val request = SeeWeekReqeust()
        request.groupId = util.getInt(this@SeeWeekNews,StaticClass.GROUP_ID,1)
        request.pageNum = 1
        request.userId = util.getInt(this@SeeWeekNews,StaticClass.USER_ID,1)
        request.weekNum = util.getInt(this@SeeWeekNews,StaticClass.WEEK_NUM,1)
        val gson = Gson()
        var route = (gson.toJson(request))
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        l.d(route)
        RequestUtil.observable
                .ISeeWeek(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    SeeWeekResponse->
                    dialog!!.dismiss()
                    l.d("${SeeWeekResponse.reports == null}")
                    if(SeeWeekResponse.reports != null){
                        for (item in SeeWeekResponse.reports!!){list.add(item) }
                        var adapter = SeeAdapter(this@SeeWeekNews,list!!,this)
                        see_recyview.layoutManager = sp
                        see_recyview.adapter = adapter
                    }else{
                        Toast.makeText(this@SeeWeekNews,"您还没有周报喔",Toast.LENGTH_SHORT)
                    }

                },{error->
                    dialog!!.dismiss()
                    Toast.makeText(this@SeeWeekNews,"服务器出现错误",Toast.LENGTH_SHORT)})
    }


}
