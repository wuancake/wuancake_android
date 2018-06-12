package com.example.administrator.wuanandroid.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.text.TextUtils
import android.view.View
import android.widget.CompoundButton

import android.widget.Toast
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginRequestBean
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean

import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R

import com.example.administrator.wuanandroid.utils.L
import com.example.administrator.wuanandroid.utils.RequestUtil
import com.example.administrator.wuanandroid.utils.SharedUtil
import com.example.administrator.wuanandroid.utils.StaticClass
import com.google.gson.Gson

import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody



import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid
 * 文件名：   LoginActivity
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-17:54
 * 描述：      登录模块
 */

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    val l: L = L()
    val sharedUtil: SharedUtil = SharedUtil()
    var isRemeber :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_login.setOnClickListener(this)
        login_register.setOnClickListener(this)
        var isRemeber = sharedUtil.getString(this@LoginActivity,StaticClass.ISREMEBER,"0")
        l.d("$isRemeber")
        login_remeber.setChecked(isRemeber.equals("1"))
        if(isRemeber.equals("1")){
            login_account.setText(sharedUtil.getString(this@LoginActivity,StaticClass.USER_ACCOUNT,""))
            login_password.setText(sharedUtil.getString(this@LoginActivity,StaticClass.USER_PASSWORD,""))
        }
    }

    private fun toLogin(accountStr: String, passwordStr: String) {
        val login = LoginRequestBean()
        val route = StringBuilder()
        login.email = accountStr
        login.password = passwordStr
        val gson = Gson()
        route.append(gson.toJson(login))
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route.toString())
        RequestUtil.observable.login(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({ LoginRsultBean ->
                    when (LoginRsultBean.infoCode) {
                        200 -> {
                            l.i("${login_remeber.isChecked}")
                            if(isRemeber.equals("0")){
                                sharedUtil.putString(this@LoginActivity,StaticClass.ISREMEBER,"0")
                            }else{
                                sharedUtil.putString(this@LoginActivity,StaticClass.ISREMEBER,"1")
                            }
                            sharedUtil.putInt(this@LoginActivity,StaticClass.GROUP_ID,LoginRsultBean.groupId)
                            sharedUtil.putInt(this@LoginActivity,StaticClass.USER_ID,LoginRsultBean.userId)
                            sharedUtil.putString(this@LoginActivity,StaticClass.USER_ACCOUNT,accountStr)
                            sharedUtil.putString(this@LoginActivity,StaticClass.USER_PASSWORD,passwordStr)
                            l.d("Login200")
                            if(LoginRsultBean.groupId == 0){
                                startActivity(Intent(this@LoginActivity,GroupingActivity::class.java))
                                finish()
                            }else{
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                finish()
                            }
                        }
                        500 -> Toast.makeText(this@LoginActivity, "${LoginRsultBean.infoText}", Toast.LENGTH_SHORT).show()
                    }



                }, {
                    l.i("${it.message}")
                })


    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_login -> {
                val accountStr = login_account.text.toString().trim()
                val passwordStr = login_password.text.toString().trim()
                if (!TextUtils.isEmpty(accountStr) and !TextUtils.isEmpty(passwordStr)) {
                    toLogin(accountStr, passwordStr)
                }
                if (TextUtils.isEmpty(accountStr) || TextUtils.isEmpty(passwordStr)) {
                    Toast.makeText(this@LoginActivity, "账号或密码不能为空", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.login_register -> startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}
