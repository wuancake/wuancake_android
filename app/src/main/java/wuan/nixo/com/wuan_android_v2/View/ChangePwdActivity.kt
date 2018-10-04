package wuan.nixo.com.wuan_android_v2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_change_pwd.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api
import wuan.nixo.com.wuan_android_v2.Common.Api.UPDATEPASSWORD
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

class ChangePwdActivity :BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_change_pwd

    override fun initView() {
        tv_title.text = "修改密码"
        iv_back.setOnClickListener { finish() }
        et_oldpwd.inputType = InputType.TYPE_NULL
        et_oldpwd.setOnClickListener { et_oldpwd.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD }
        //点击事件
        pwd_set.setOnClickListener {
            (et_oldpwd.text.toString().isNull() || et_newpwd1.text.toString().isNull() ||
                    et_newpwd2.text.toString().isNull() ).yes {
                ToastUtils.newToastCenter(this@ChangePwdActivity,"输入框不能为空")
            }.otherwise {
                (et_newpwd1.text.toString() == et_newpwd2.text.toString()).yes {
                    var dialog = QuestionsDialog(this@ChangePwdActivity)
                    dialog.setMessage("确认修改密码？")
                    dialog.setCancel("在考虑一下") { _, _->  dialog.dismiss() }
                    dialog.setConfirm("确认") { _, _->
                        dialog.dismiss()
                        changePassWord(et_oldpwd.text.toString(),et_newpwd1.text.toString(),
                                et_newpwd2.text.toString())
                    }

                }
            }
        }


    }

    private fun changePassWord(old: String, new1: String, new2: String){
        var map = HashMap<String,Any>()
        map.put("id", SharedUtil().getInt(this@ChangePwdActivity,"userId",0))
        map.put("password",old)
        map.put("newPassword",new1)
        map.put("confirmPasswd",new2)
        MyOkHttpUtils.postJson().json(map).url(UPDATEPASSWORD).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                var bean = Gson().fromJson(response, BaseModel::class.java)
                ToastUtils.newToastCenter(this@ChangePwdActivity,bean.infoText)
                finish()
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                ToastUtils.newToastCenter(this@ChangePwdActivity,"网络连接失败")
            }
        })


    }


}
