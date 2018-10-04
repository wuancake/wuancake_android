package wuan.nixo.com.wuan_android_v2.View

import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.LOGIN
import wuan.nixo.com.wuan_android_v2.Ext.*
import wuan.nixo.com.wuan_android_v2.MainActivity
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil

import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity

class LoginActivity : BaseActivity() , View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.activity_login



    override fun initView() {
        tv_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        if(SharedUtil().getInt(this@LoginActivity,"userId",0)!=0){
            startActivity(MainActivity::class.java)
            finish()
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            tv_login -> {
                val account = et_account.text.toString().trim()
                val password = et_password.text.toString().trim()
                Log.i("Nixo", account + "------>>----" + password)
                println("isNull返回值-------------》"+account.isNull())

                (account.isNull()).yes {
                    ToastUtils.newToastCenter(this, "请输入邮箱")
                }.otherwise {
                    (password.isNull()).yes {
                        ToastUtils.newToastCenter(this, "请输入密码")
                    }.otherwise {
                        (account.contains("@")).yes {
                            login(account, password)
                        }.otherwise {
                            ToastUtils.newToastCenter(this, "请输入正确的邮箱格式")
                        }
                    }
                }
            }
            tv_register -> {
                startActivity(RegisterActivity::class.java)
            }
        }
    }



    fun login(account: String, password: String) {
        var map = HashMap<String, String>()
        map.put("email", account)
        map.put("password", password)
        MyOkHttpUtils.postJson().json(map).url(LOGIN).build().execute(object : StringCallback() {
            override fun onError(call: Call, e: Exception, id: Int) {
                e.printStackTrace()
                ToastUtils.newToastCenter(this@LoginActivity,"网络连接失败")

            }

            override fun onResponse(response: String, id: Int) {
                val bean = Gson().fromJson<BaseModel>(response,BaseModel::class.java)
                if("500".equals(bean.infoCode)){
                    ToastUtils.newToastCenter(this@LoginActivity,"登录失败")
                }else if("200".equals(bean.infoCode)){
                    if(bean.groupId == 0){
                        startActivity(GroupActivity::class.java)
                    }else{
                        SharedUtil().putString(this@LoginActivity,"email",account)
                        SharedUtil().putString(this@LoginActivity,"name","${bean.userName}")
                        SharedUtil().putString(this@LoginActivity,"groupName","${bean.groupName}")
                        SharedUtil().putInt(this@LoginActivity,"userId",bean.userId)
                        SharedUtil().putInt(this@LoginActivity,"groupId",bean.groupId)
                        ToastUtils.newToastCenter(this@LoginActivity,"登录成功")
                        startActivity(MainActivity::class.java)
                        finish()
                    }

                }else{
                    ToastUtils.newToastCenter(this@LoginActivity,bean.infoText)
                }
            }
        })
    }
}