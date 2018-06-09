package com.example.administrator.wuanandroid.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.wuanandroid.Bean.CancelLeaveBean.CancelRequest
import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.*
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_leave.view.*
import okhttp3.RequestBody

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   LeaveFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:52
 * 描述：
 */

class LeaveFragment : Fragment() {

    var sharedUtil = SharedUtil()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_leave, container, false)
        var mLeaveTimer = view.leave_timer
        var mCancelLeave = view.cancel_Leave
        CountDownUtil(StaticClass.TIMER_TIME,1000,mLeaveTimer).start()
        mCancelLeave.setOnClickListener {


            val g : Gson = Gson()
            var sb = CancelRequest()
            sb.userId = sharedUtil.getInt(this!!.activity!!,StaticClass.USER_ID,1)
            var route = g.toJson(sb)
            val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route.toString())
            RequestUtil.observable.ICanceLeave(body)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe{
                        StatusBean-> when(StatusBean.infoCode) {
                        200->{
//
                            startActivity(Intent(this!!.activity!!,MainActivity::class.java))
                        }
//

                    }
                    }


        }
        return view
    }
}
