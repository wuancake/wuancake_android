package com.example.administrator.wuanandroid

import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast

import com.example.administrator.wuanandroid.Bean.StatusBean.StatusBean
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusRequestBean
import com.example.administrator.wuanandroid.fragment.ComitedFragment
import com.example.administrator.wuanandroid.fragment.ComitntFragment
import com.example.administrator.wuanandroid.fragment.InternetFail
import com.example.administrator.wuanandroid.fragment.LeaveFragment
import com.example.administrator.wuanandroid.ui.SeeWeekNews
import com.example.administrator.wuanandroid.utils.L
import com.example.administrator.wuanandroid.utils.RequestUtil
import com.example.administrator.wuanandroid.utils.SharedUtil
import com.example.administrator.wuanandroid.utils.StaticClass
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_write.*

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val l : L = L()
    val sharedUtil : SharedUtil = SharedUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "" //清空标题栏
        setSupportActionBar(toolbar_main)
        navOnClick() //侧滑栏点击事件
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(R.mipmap.opendrawer)
        }
        //         replaceFragent(new ComitntFragment()); //测试
        RequestToStatus()
    }

    private fun intoFragment(status: Int) {
        //根据返回不同的status来判断是否提交周报加载不同的fragment
        //1为提交，0为没提交，3为已请假 -1为加载失败 Error 500
        when(status){
            -1 -> replaceFragent(InternetFail())
            1 -> replaceFragent(ComitntFragment())
            2 -> replaceFragent(ComitedFragment())
            3 -> replaceFragent(LeaveFragment())
        }
    }

    fun navOnClick() {
        nav_view!!.setNavigationItemSelectedListener {
            mDrawerLayout!!.closeDrawer(nav_view!!)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> mDrawerLayout!!.openDrawer(Gravity.START)
            R.id.nav_main -> mDrawerLayout!!.closeDrawer(nav_view!!)
            R.id.nav_myNews -> {
                val intent = Intent(this@MainActivity, SeeWeekNews::class.java)
                startActivity(intent)
            }
            R.id.nav_exit -> System.exit(0)
        }
        return true
    }


    private fun replaceFragent(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_main, fragment)
        transaction.commit()
    }


    private fun RequestToStatus() {
        val g : Gson = Gson()
        var route : String
        route = g.toJson(sharedUtil.getInt(this,StaticClass.USER_ID,-1))
        var body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        RequestUtil.observable.IStatus(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    StatusBean-> when(StatusBean.infoCode){
                    200 ->{ intoFragment(StatusBean.status)}
                    500->{ intoFragment(-1)}
                }
                }
    }
}
