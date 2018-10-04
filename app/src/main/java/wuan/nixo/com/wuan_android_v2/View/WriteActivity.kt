package wuan.nixo.com.wuan_android_v2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.SUBMIT
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

class WriteActivity : BaseActivity(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_write

    override fun onClick(p0: View?) {
        when(p0){
            week_over->week_over.inputType = InputType.TYPE_CLASS_TEXT
            write_set->{
                (week_over.text.toString().isNull()).yes {
                    ToastUtils.newToastCenter(this@WriteActivity,"本周完成不能为空")
                }.otherwise {
                    (week_next.text.toString().isNull()).yes {
                        ToastUtils.newToastCenter(this@WriteActivity,"本周问题不能为空")
                    }.otherwise {
                        (week_next.text.toString().isNull()).yes {
                            ToastUtils.newToastCenter(this@WriteActivity,"下周计划不能为空")
                        }.otherwise {
                            var dialog  = QuestionsDialog(this@WriteActivity)
                            dialog.setMessage("您确认提交周报吗")
                            dialog.show()
                            dialog.setCancel("编辑") { _, _->  dialog.dismiss() }
                            dialog.setConfirm("提交") { _, _->
                                upSetWeekPaupe(week_over.text.toString(),week_next.text.toString
                                (),week_next.text.toString(),week_url.text.toString())
                            }
                        }
                    }

                }
            }
        }
    }



    override fun initView() {
        tv_title.text = "提交周报"
        week_over.inputType = InputType.TYPE_NULL

        iv_back.setOnClickListener { finish() }
        week_over.setOnClickListener(this)
        week_wenti.setOnClickListener(this)
        week_next.setOnClickListener(this)
        week_url.setOnClickListener(this)
        write_set.setOnClickListener(this)
    }

    fun upSetWeekPaupe(over:String , wenti:String , next :String , url :String){
        var map = HashMap<String,Any>()
        map.put("userId",SharedUtil().getInt(this@WriteActivity,"userId",0))
        map.put("groupId",SharedUtil().getInt(this@WriteActivity,"groupId",0))
        map.put("complete",over)
        map.put("trouble",wenti)
        map.put("plane",next)
        map.put("url",url)
        MyOkHttpUtils.postJson().json(map).url(SUBMIT).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                var bean = Gson().fromJson(response,BaseModel::class.java)
                ("200" == bean.infoCode).yes{
                    ToastUtils.newToastCenter(this@WriteActivity,"提交成功")
                    finish()
                }.otherwise {
                    ToastUtils.newToastCenter(this@WriteActivity,"提交失败，请重试")
                }
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {

            }
        })

    }

}
