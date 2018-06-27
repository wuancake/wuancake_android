package com.example.administrator.wuanandroid.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.example.administrator.wuanandroid.Adapter.GroupAdapter
import com.example.administrator.wuanandroid.Adapter.GroupItemClickListener
import com.example.administrator.wuanandroid.Bean.GroupBean.AllGroupBean
import com.example.administrator.wuanandroid.Bean.GroupBean.GroupRequest
import com.example.administrator.wuanandroid.Bean.GroupBean.GroupResponse
import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.*
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_grouping.*
import okhttp3.RequestBody
import android.content.DialogInterface




class GroupingActivity :AppCompatActivity(), View.OnClickListener,GroupItemClickListener {
    override fun ClickListner(num: Int) {

        val builder = AlertDialog.Builder(this@GroupingActivity)
        builder.setTitle("分组选择")
                .setMessage("您确定选择该分组吗")
                .setPositiveButton("确定", DialogInterface.OnClickListener { dialog, id ->
                    group_id = num
                    l.i(""+group_id)
                    netRequest()})
                .setNegativeButton("取消", DialogInterface.OnClickListener { dialog, id ->group_id = 0 })
        builder.create()
        builder.show()

    }

    private var group_id: Int = 0
    private var sharedUtil = SharedUtil()
    private var toast = ToastUtil(this)
    private var l = L()
    private var t = ToastUtil(this@GroupingActivity)
    var dialog :Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grouping)
        getGroupList()

//        dialog = DialogUtil(this@GroupingActivity).getLoaddingDialog()
    }

    fun getGroupList(){
//        dialog!!.show()
//        dialog!!.setCancelable(false)
        RequestUtil.observable.getAllGroup()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({

                    AllGroupBean->
//                    dialog!!.dismiss()
                    var list = ArrayList<AllGroupBean.GroupsBean>()
                    l.i("执行了")
                    for (item in AllGroupBean.groups!!){list.add(item) }
                    var manager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                    var adapter = GroupAdapter(this@GroupingActivity,list,this)
                    group_recycler.layoutManager = manager
                    group_recycler.adapter = adapter

                },{
//                    dialog!!.dismiss()
                    t.st("发生${it.message}错误")
        })
    }

    override fun onClick(v: View) {
        when (v.id) {

        }
    }


    private fun netRequest() {
//        dialog!!.show()
        var gr = GroupRequest()
        gr.userId = sharedUtil.getInt(this@GroupingActivity,StaticClass.USER_ID,1)
        gr.groupId = group_id
        var gson = Gson()
        var strGr = gson.toJson(gr)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), strGr)
        RequestUtil.observable.IGroup(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    GroupResponse ->
//                    dialog!!.dismiss()
                    when(GroupResponse.infoCode){
                        200 -> {
                            sharedUtil.putInt(this@GroupingActivity,StaticClass.USER_ID, GroupResponse.userId!!)
                            sharedUtil.putInt(this@GroupingActivity,StaticClass.GROUP_ID,GroupResponse.groupId!!)
                            toast.lt(GroupResponse.infoText)
                            groupingToMain()
                        }
                        500 ->{toast.st(GroupResponse.infoText)}
                    }
                }

    }

    private fun groupingToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}