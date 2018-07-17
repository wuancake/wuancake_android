package com.example.administrator.wuanandroid

import android.app.Dialog
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.media.VolumeShaper
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Process.myPid
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import com.allenliu.versionchecklib.v2.AllenVersionChecker
import com.allenliu.versionchecklib.v2.builder.UIData

import com.example.administrator.wuanandroid.Bean.StatusBean.StatusRequestBean
import com.example.administrator.wuanandroid.R.id.*

import com.example.administrator.wuanandroid.fragment.ComitedFragment
import com.example.administrator.wuanandroid.fragment.ComitntFragment
import com.example.administrator.wuanandroid.fragment.InternetFail
import com.example.administrator.wuanandroid.fragment.LeaveFragment
import com.example.administrator.wuanandroid.ui.BaseActivity
import com.example.administrator.wuanandroid.ui.LoginActivity
import com.example.administrator.wuanandroid.ui.SeeWeekNews
import com.example.administrator.wuanandroid.utils.*
import com.google.gson.Gson

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

import okhttp3.RequestBody
import org.json.JSONObject
import java.net.URL
import java.security.cert.PKIXRevocationChecker
import java.util.*

class MainActivity : AppCompatActivity() {

    var t = ToastUtil(this@MainActivity)
    val l : L = L()
    val sharedUtil : SharedUtil = SharedUtil()
    var dialog : Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = DialogUtil(this@MainActivity).getLoaddingDialog()
        dialog!!.setCancelable(false)
//        dialog!!.show()
        toolbar_main.title = " " //清空标题栏
        setSupportActionBar(toolbar_main)

        navOnClick() //侧滑栏点击事件
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(R.mipmap.opendrawer)
        }
//                intoFragment("1")


        RequestToStatus()
    }

    private fun intoFragment(status: String) {
        //根据返回不同的status来判断是否提交周报加载不同的fragment
        // 1未提交，2已提交，3已请假 -1为加载失败 Error 500
        l.i(status)

        when(status){
            "-1" -> replaceFragent(InternetFail())
            "1" -> replaceFragent(ComitntFragment())
            "2" -> replaceFragent(ComitedFragment())
            "3" -> replaceFragent(LeaveFragment())
        }
    }

    fun navOnClick() {
        nav_view.setNavigationItemSelectedListener {

           item: MenuItem ->
            when(item.itemId){
                R.id.nav_myNews -> { startActivity(Intent(this@MainActivity, SeeWeekNews::class.java)) }
                R.id.nav_main -> mDrawerLayout!!.closeDrawer(nav_view)
                R.id.nav_exit -> {
                startActivity(Intent(this@MainActivity,LoginActivity::class.java))
                    finish()
                }

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> mDrawerLayout!!.openDrawer(Gravity.START)

        }
        return true
    }



    private fun replaceFragent(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_main, fragment)
        transaction.commit()
    }


    private fun update(context: Context, Version :Double, url : String){
        AllenVersionChecker
                .getInstance()

                .downloadOnly(
                        UIData
                                .create()
                                .setTitle("午安煎饼客户端")
                                .setContent("发现了新版本")
                                .setDownloadUrl(url)
                )
                .excuteMission(context)

    }

    private fun RequestToStatus() {
        val g : Gson = Gson()
        var sb = StatusRequestBean()
        sb.userId = sharedUtil.getInt(this,StaticClass.USER_ID,1)
        var route = g.toJson(sb)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route.toString())
        RequestUtil.observable.IStatus(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    StatusBean-> when(StatusBean.infoCode){
                    200 ->{
                        dialog!!.dismiss()
                        intoFragment("${StatusBean.status}")
                            sharedUtil.putInt(this@MainActivity,StaticClass.WEEK_NUM,StatusBean.weekNum)
                        if(StatusBean.version!=null) {
                            if (StatusBean.version!!.v > StaticClass.WUAN_VERSION) {
                                l.i("版本" + "${StatusBean.version!!.v}")
                                update(this@MainActivity, StatusBean!!.version!!.v, StatusBean!!.version!!.url!!)
                            }
                        }
                    }
                    500->{
                        dialog!!.dismiss()
                        intoFragment("-1")}
                }
                }
    }
}
