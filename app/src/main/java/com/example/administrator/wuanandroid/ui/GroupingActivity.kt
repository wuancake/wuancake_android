package com.example.administrator.wuanandroid.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.administrator.wuanandroid.Bean.GroupBean.GroupRequest
import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.RequestUtil
import com.example.administrator.wuanandroid.utils.SharedUtil
import com.example.administrator.wuanandroid.utils.StaticClass
import com.example.administrator.wuanandroid.utils.ToastUtil
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_grouping.*
import okhttp3.RequestBody


class GroupingActivity : AppCompatActivity(), View.OnClickListener {

    private var group_id: Int = 0
    private var sharedUtil = SharedUtil()
    private var t = ToastUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grouping)
        initView()
    }

    private fun initView() {
        WebGroup.setOnClickListener(this)
        PhpGroup.setOnClickListener(this)
        JavaGroup.setOnClickListener(this)
        UiGroup.setOnClickListener(this)
        PmGroup.setOnClickListener(this)
        AndroidGroup.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.WebGroup -> group_id = 1
            R.id.PhpGroup -> group_id = 2
            R.id.JavaGroup -> group_id = 3
            R.id.UiGroup -> group_id = 4
            R.id.PmGroup -> group_id = 5
            R.id.AndroidGroup -> group_id = 6
        }
        netRequest()
    }


    private fun netRequest() {
        var gr = GroupRequest()
        gr.groupId = group_id
        gr.userId = sharedUtil.getInt(this@GroupingActivity,StaticClass.USER_ID,0)
        var gson = Gson()
        var strGr = gson.toJson(gr)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), strGr)
        RequestUtil.observable.IGroup(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    GroupResponse ->
                    when(GroupResponse.infoCode){
                        200 -> {
                            sharedUtil.putInt(this@GroupingActivity,StaticClass.USER_ID,GroupResponse.userId)
                            sharedUtil.putInt(this@GroupingActivity,StaticClass.GROUP_ID,GroupResponse.groupId)
                            t.lt(GroupResponse.infoText)
                            groupingToMain()
                        }
                        500 ->{t.st(GroupResponse.infoText)}
                    }
                }
    }

    private fun groupingToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}