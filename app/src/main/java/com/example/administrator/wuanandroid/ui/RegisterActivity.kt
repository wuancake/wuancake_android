package com.example.administrator.wuanandroid.ui


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.administrator.wuanandroid.Bean.RegisterBean.RegisterRequest

import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.*

import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.RequestBody

class RegisterActivity :AppCompatActivity(), View.OnClickListener {

    var l = L()
    var sharedUtil = SharedUtil()
    var t = ToastUtil(this@RegisterActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Submit.setOnClickListener(this)                 //提交按钮监听
        Login.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.Submit -> Submit()
            R.id.Login -> registerToLogin()
        }
    }

    private fun Submit() {
        if (RegisterPassword.text.toString() != RegisterPassword2.text.toString()) {     //两次密码输入不一样
            Toast.makeText(applicationContext, "两次密码输入不一致，请重新核对", Toast.LENGTH_SHORT).show()
        } else
            netRequest()
    }
//    RegisterUsername.text.toString(), RegisterEmail.text.toString(), RegisterQQNum, RegisterPassword.text.toString()
    private fun netRequest() {
    var mRegrquest : RegisterRequest = RegisterRequest()
    mRegrquest.userName = RegisterUsername.text.toString()
    mRegrquest.email = RegisterEmail.text.toString()
    mRegrquest.password = RegisterPassword.text.toString()
    mRegrquest.qq = RegisterQQ.text.toString()
    var gson = Gson()
    var route = gson.toJson(mRegrquest)
    val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        RequestUtil.observable.IRegister(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    RegisterResponse->
                    when(RegisterResponse.infoCode){
                        200 ->{
                            sharedUtil.putInt(this@RegisterActivity, StaticClass.USER_ID, RegisterResponse.userId)
                            sharedUtil.putInt(this@RegisterActivity, StaticClass.GROUP_ID, RegisterResponse.groupId)
                            t.st("注册成功！")
                            registerToLogin()
                        }
                        500 ->{
                            t.st("${RegisterResponse.infoText}")
                        }

                }},{
                    error->Toast.makeText(this@RegisterActivity, "网络出现错误", Toast.LENGTH_SHORT).show()
                })
    }

    private fun registerToLogin() {

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

}
