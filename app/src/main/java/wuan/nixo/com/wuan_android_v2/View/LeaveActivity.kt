package wuan.nixo.com.wuan_android_v2.View

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_leave.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.LEAVE
import wuan.nixo.com.wuan_android_v2.Ext.isNull
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.dialog.QuestionsDialog
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity
import java.lang.Exception

class LeaveActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_leave

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initView() {
        tv_title.text = "我要请假"
        iv_back.setOnClickListener { finish() }




        //提交请假
        leave_set.setOnClickListener {
            (et_leave.text.toString().isNull()).yes {
                ToastUtils.newToastCenter(this@LeaveActivity,"请输入请假理由")
            }.otherwise {
                var dialog  = QuestionsDialog(this@LeaveActivity)

                dialog.setMessage("您确定请假吗？")
                dialog.show()

                dialog.setCancel("在考虑一下") { _, _->  dialog.dismiss() }
                dialog.setConfirm("确认") { _, _ ->
                    var weekStr :String = sp_week.selectedItem.toString()
                    var week = 0
                    Log.i("Nixo",weekStr)
                    when(weekStr){
                        "一周" -> week = 1
                        "两周" -> week = 2
                        "三周" -> week = 3
                    }
                    var map = HashMap<String,Any>()
                    map.put("userId",SharedUtil().getInt(this@LeaveActivity,"userId",0))
                    map.put("groupId",SharedUtil().getInt(this@LeaveActivity,"groupId",0))
                    map.put("weekNum",week)
                    map.put("reason",et_leave.text.toString())
                    MyOkHttpUtils.postJson().json(map).url(LEAVE).build().execute(object :
                            StringCallback() {
                        override fun onResponse(response: String?, id: Int) {
                            var bean = Gson().fromJson(response,BaseModel::class.java)
                            ("200" == bean.infoCode).yes{
                                ToastUtils.newToastCenter(this@LeaveActivity,"请假成功")
                                finish()
                            }.otherwise {
                                ToastUtils.newToastCenter(this@LeaveActivity,"${bean.infoText}")
                            }
                        }

                        override fun onError(call: Call?, e: Exception?, id: Int) {
                            ToastUtils.newToastCenter(this@LeaveActivity,"网络连接失败")
                        }

                    })
                }
            }
        }


    }




}
