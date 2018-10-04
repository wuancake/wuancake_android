package wuan.nixo.com.wuan_android_v2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback

import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.REGISTER
import wuan.nixo.com.wuan_android_v2.Ext.isNull
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.MainActivity
import wuan.nixo.com.wuan_android_v2.Model.RegisterModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.R.id.tv_register
import wuan.nixo.com.wuan_android_v2.utils.StringUtils
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity
import java.lang.Exception

class RegisterActivity :BaseActivity(), View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.activity_register

    override fun initView() {
        tv_register.setOnClickListener(this)
        tv_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            tv_register->{
                et_username.text.toString().isNull().yes {
                    ToastUtils.newToastCenter(this,"用户名不能为空")
                    return
                }
                et_qq.text.toString().isNull().yes {
                    ToastUtils.newToastCenter(this,"注册QQ不能为空")
                }
                et_email.text.toString().isNull().yes {
                    ToastUtils.newToastCenter(this,"邮箱不能为空")
                }
                et_pwd.text.toString().isNull().yes {
                    ToastUtils.newToastCenter(this,"注册密码不能为空")
                }
                et_qpwd.text.toString().isNull().yes {
                    ToastUtils.newToastCenter(this,"确认密码不能为空")
                    return
                }
                (et_pwd.text.toString().equals(et_qpwd.text.toString())).yes {
                    register()
                }.otherwise {
                    ToastUtils.newToastCenter(this,"密码输入不一致,请重新输入")
                }

            }

            tv_login -> {
                finish()
            }
        }
    }

    fun register(){
        var map = HashMap<String, String>()
        map.put("userName", et_username.text.toString().trim())
        map.put("email", et_email.text.toString().trim())
        map.put("QQ", et_qq.text.toString().trim())
        map.put("password", et_pwd.text.toString().trim())
        MyOkHttpUtils.postJson().json(map).url(REGISTER).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                var bean = Gson().fromJson(response,RegisterModel::class.java)
                ("200".equals(bean.infoCode)).yes {
                    (bean.groupId == 0) .yes {
//                        跳到选择分组
                        ToastUtils.newToastCenter(this@RegisterActivity,bean.infoText)
                        startActivity(GroupActivity::class.java)
                    }.otherwise {
                        startActivity(MainActivity::class.java)
                    }
                }.otherwise {
                    ToastUtils.newToastCenter(this@RegisterActivity,bean.infoText)
                }
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                ToastUtils.newToastCenter(this@RegisterActivity,"网络连接失败")

            }
        })
    }

}




