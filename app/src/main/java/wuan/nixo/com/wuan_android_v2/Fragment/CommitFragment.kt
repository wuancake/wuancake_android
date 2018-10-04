package wuan.nixo.com.wuan_android_v2.Fragment

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.fragment_commited.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.CANCELLEAVE
import wuan.nixo.com.wuan_android_v2.Common.Api.MAIN
import wuan.nixo.com.wuan_android_v2.Common.StaticClass

import wuan.nixo.com.wuan_android_v2.Ext.SharedExt
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.Model.MainModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.View.LeaveActivity
import wuan.nixo.com.wuan_android_v2.View.WriteActivity
import wuan.nixo.com.wuan_android_v2.utils.CountDownUtil
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import java.lang.Exception

class CommitFragment :BaseFragment() , View.OnClickListener{
    override val resourceView: Int
        get() = R.layout.fragment_commited




    override fun initView(savedInstanceState: Bundle?) {


    }


    override fun onResume() {
        super.onResume()
        var userId:Int = SharedUtil().getInt(activity!!.baseContext,"userId",0)
        var map  = HashMap<String,Int>()
        map.put("userId",userId)
        MyOkHttpUtils.postJson().json(map).url(MAIN).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                var bean = Gson().fromJson(response,MainModel::class.java)
                ("200".equals("${bean.infoCode}")).yes{
                    SharedUtil().putInt(activity!!.baseContext,"week",bean.weekNum)
                    SharedUtil().putString(activity!!.baseContext,"status","${bean.status}")
                    when(bean.status){
                        1->{
                            commit_parpue.setOnClickListener(this@CommitFragment)
                            commit_leave.setOnClickListener(this@CommitFragment)
                            commitnt_week.text = "未提交,距离${bean.weekNum}周结束还剩:"
                            rv_commitnt.visibility = View.VISIBLE
                            commitnt_bottom.visibility = View.VISIBLE
                            rv_leave.visibility = View.GONE
                            CountDownUtil(StaticClass.TIMER_TIME,1000,commitnt_d,commitnt_h,
                                    commitnt_m,commitnt_s).start()
                            commitnt_bottom.visibility = View.VISIBLE
                        }
                        2->{
                            commitnt_week.text = "已提交,距离${bean.weekNum}周结束还剩:"
                            rv_commitnt.visibility = View.VISIBLE
                            commitnt_bottom.visibility = View.GONE
                            rv_leave.visibility = View.GONE
                            commit_parpue.setOnClickListener(this@CommitFragment)
                            commit_leave.setOnClickListener(this@CommitFragment)
                            CountDownUtil(StaticClass.TIMER_TIME,1000,commitnt_d,commitnt_h,
                                    commitnt_m,commitnt_s).start()
                        }
                        3->{
                            cancel_leave.setOnClickListener(this@CommitFragment)
                            commitnt_week.text = "已请假,距离${bean.weekNum}周结束还剩:"
                            rv_commitnt.visibility = View.GONE
                            commitnt_bottom.visibility = View.GONE
                            rv_leave.visibility = View.VISIBLE
                            CountDownUtil(StaticClass.TIMER_TIME,1000,commitnt_d,commitnt_h,
                                    commitnt_m,commitnt_s).start()
                        }
                        else ->{
                            ToastUtils.newToastCenter(context,"服务器响应失败")
                            rv_commitnt.visibility = View.GONE
                            commitnt_header.visibility = View.GONE
                            rv_leave.visibility = View.GONE
                        }
                    }
                }.otherwise {
                    ToastUtils.newToastCenter(context,"服务器响应失败")

                }
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                e!!.printStackTrace()
                ToastUtils.newToastCenter(context,"服务器响应失败")
            }
        })
    }

    fun cancenLeave(){
        var userId:Int = SharedUtil().getInt(activity!!.baseContext,"userId",0)
        var groupId:Int = SharedUtil().getInt(activity!!.baseContext,"groupId",0)
        var map  = HashMap<String,Int>()
        map.put("userId",userId)
        map.put("groupId",groupId)
        MyOkHttpUtils.postJson().json(map).url(CANCELLEAVE).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                var bean = Gson().fromJson(response, BaseModel::class.java)
                ("200" == bean.infoCode).yes{
                    ToastUtils.newToastCenter(activity!!.baseContext,"请假成功")
                    onResume()
                }.otherwise {
                    ToastUtils.newToastCenter(activity!!.baseContext,"${bean.infoText}")
                }
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                ToastUtils.newToastCenter(activity!!.baseContext,"网络连接失败")
            }
        })

    }

    override fun onClick(p0: View?) {
        when(p0){
            commit_parpue->{
                startActivity(WriteActivity::class.java)
            }
            commit_leave->{
                startActivity(LeaveActivity::class.java)
            }
            cancel_leave->{
                cancenLeave()
            }

        }
    }

}