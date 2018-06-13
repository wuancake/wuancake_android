package com.example.administrator.wuanandroid.ui

import android.content.Intent
import android.graphics.PointF
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.text.TextUtils
import android.view.View
import android.widget.CompoundButton

import android.widget.Toast
import com.example.administrator.wuanandroid.Bean.CircleBean
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginRequestBean
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean

import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.mView.DisplayUtils

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
import java.util.ArrayList


/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid
 * 文件名：   LoginActivity
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-17:54
 * 描述：      登录模块
 */

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val circleBeanList = ArrayList<CircleBean>()
    val l: L = L()
    val sharedUtil: SharedUtil = SharedUtil()
    var isRemeber :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_login.setOnClickListener(this)
        login_register.setOnClickListener(this)
        initPoint()
        circle_view.circleBeen = circleBeanList
        var isRemeber = sharedUtil.getString(this@LoginActivity,StaticClass.ISREMEBER,"0")
        l.d("$isRemeber")
        login_remeber.setChecked(isRemeber.equals("1"))
        if(isRemeber.equals("1")){
            login_account.setText(sharedUtil.getString(this@LoginActivity,StaticClass.USER_ACCOUNT,""))
            login_password.setText(sharedUtil.getString(this@LoginActivity,StaticClass.USER_PASSWORD,""))
        }
    }

    private fun toLogin(accountStr: String, passwordStr: String) {
        login_view.visibility = View.GONE
        circle_view.centerImg = center_tv
        circle_view.openAnimation()
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
                        500 -> {

                            login_view.visibility = View.VISIBLE
                            Toast.makeText(this@LoginActivity, "${LoginRsultBean.infoText}", Toast.LENGTH_SHORT).show()
                        }


                    }



                }, {
                    l.i("${it.message}")
                    login_view.visibility = View.VISIBLE
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



    private fun initPoint() {

        val height = DisplayUtils.getDisplayHight(this)
        val width = DisplayUtils.getDisplayWidth(this)

        val centerX = width / 2
        val centerY = height / 2


        val circleBean = CircleBean(
                PointF((-width / 5.1).toFloat(), (height / 1.5).toFloat()),
                PointF((centerX - 30).toFloat(), (height * 2 / 3).toFloat()),
                PointF((width / 2.4).toFloat(), (height / 3.4).toFloat()),
                PointF((width / 6).toFloat(), (centerY - 120).toFloat()),
                PointF((width / 7.2).toFloat(), (-height / 128).toFloat()),
                (width / 14.4).toFloat(), 60)
        val circleBean2 = CircleBean(
                PointF((-width / 4).toFloat(), (height / 1.3).toFloat()),
                PointF((centerX - 20).toFloat(), (height * 3 / 5).toFloat()),
                PointF((width / 2.1).toFloat(), (height / 2.5).toFloat()),
                PointF((width / 3).toFloat(), (centerY - 10).toFloat()),
                PointF((width / 4).toFloat(), (-height / 5.3).toFloat()),
                (width / 4).toFloat(), 60)
        val circleBean3 = CircleBean(
                PointF((-width / 12).toFloat(), (height / 1.1).toFloat()),
                PointF((centerX - 100).toFloat(), (height * 2 / 3).toFloat()),
                PointF((width / 3.4).toFloat(), (height / 2).toFloat()),
                PointF(0f, (centerY + 100).toFloat()),
                PointF(0f, 0f),
                (width / 24).toFloat(), 60)

        val circleBean4 = CircleBean(
                PointF((-width / 9).toFloat(), (height / 0.9).toFloat()),
                PointF(centerX.toFloat(), (height * 3 / 4).toFloat()),
                PointF((width / 2.1).toFloat(), (height / 2.3).toFloat()),
                PointF((width / 2).toFloat(), centerY.toFloat()),
                PointF((width / 1.5).toFloat(), (-height / 5.6).toFloat()),
                (width / 4).toFloat(), 60)

        val circleBean5 = CircleBean(
                PointF((width / 1.4).toFloat(), (height / 0.9).toFloat()),
                PointF(centerX.toFloat(), (height * 3 / 4).toFloat()),
                PointF((width / 2).toFloat(), (height / 2.37).toFloat()),
                PointF((width * 10 / 13).toFloat(), (centerY - 20).toFloat()),
                PointF((width / 2).toFloat(), (-height / 7.1).toFloat()),
                (width / 4).toFloat(), 60)
        val circleBean6 = CircleBean(
                PointF((width / 0.8).toFloat(), height.toFloat()),
                PointF((centerX + 20).toFloat(), (height * 2 / 3).toFloat()),
                PointF((width / 1.9).toFloat(), (height / 2.3).toFloat()),
                PointF((width * 11 / 14).toFloat(), (centerY + 10).toFloat()),

                PointF((width / 1.1).toFloat(), (-height / 6.4).toFloat()),
                (width / 4).toFloat(), 60)
        val circleBean7 = CircleBean(
                PointF((width / 0.9).toFloat(), (height / 1.2).toFloat()),
                PointF((centerX + 20).toFloat(), (height * 4 / 7).toFloat()),
                PointF((width / 1.6).toFloat(), (height / 1.9).toFloat()),
                PointF(width.toFloat(), (centerY + 10).toFloat()),

                PointF(width.toFloat(), 0f),
                (width / 9.6).toFloat(), 60)

        circleBeanList.add(circleBean)
        circleBeanList.add(circleBean2)
        circleBeanList.add(circleBean3)
        circleBeanList.add(circleBean4)
        circleBeanList.add(circleBean5)
        circleBeanList.add(circleBean6)
        circleBeanList.add(circleBean7)

    }


    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }
}
