package com.example.administrator.wuanandroid.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.administrator.wuanandroid.R
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.administrator.wuanandroid.Bean.setNewsBean.SetNewsRequest
import com.example.administrator.wuanandroid.Bean.setNewsBean.SetNewsResponse
import com.example.administrator.wuanandroid.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.content_xd.*

class WriteActivity : AppCompatActivity() {

    var week_overEdit:String? = null
    var week_helpEdit:String? = null
    var next_weekEdit:String? = null
    var  urlEdit:String? = null
    var util = SharedUtil()
    var l = L()
    var t = ToastUtil(this@WriteActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        initView()
        setSupportActionBar(toolbar)
        toolbar.setTitle("")
    }

    private fun initView() {
        write_back.setOnClickListener(View.OnClickListener { finish() })
        write_save.setOnClickListener(View.OnClickListener {
            getWeekText()
            if (week_overEdit!!.length < 1 || week_helpEdit!!.length < 1 || next_weekEdit!!.length < 1) {
                Toast.makeText(this@WriteActivity, "必填项不能为空", Toast.LENGTH_SHORT).show()
            } else {
                saveWeekNews()
                goMain(1)

            }
        })
        write_set.setOnClickListener(View.OnClickListener {
            if (util.getString(this@WriteActivity, "week_over", "无") != null
                    &&
                    util.getString(this@WriteActivity, "next_week", "无") != null
                    &&
                    util.getString(this@WriteActivity, "week_help", "无") != null) {
                tijiao(
                        util.getString(this@WriteActivity, "week_over", "无"),
                        util.getString(this@WriteActivity, "week_help", "无"),
                        util.getString(this@WriteActivity, "next_week", "无"),
                        util.getString(this@WriteActivity, "url", "无")
                )
            }
            getWeekText()
            if (week_overEdit!!.length < 1 || week_helpEdit!!.length < 1 || next_weekEdit!!.length < 1) {
                Toast.makeText(this@WriteActivity, "必填项不能为空", Toast.LENGTH_SHORT).show()
            } else {
                tijiao(week_overEdit, week_helpEdit, next_weekEdit, urlEdit)
            }
        })
    }

    fun getWeekText() {
        var week_overEdit = week_over.text.toString()
        var week_helpEdit = week_help.text.toString()
        var next_weekEdit = week_help.text.toString()
        var  urlEdit = url.text.toString()
    }

    private fun tijiao(week_over: String?, week_help: String?, next_week: String?, url: String?) {
        val request = SetNewsRequest()
        //封装实体类
        request.userId = Integer.parseInt(util.getString(this@WriteActivity, "UserId", "1"))
        request.groupId = util.getInt(this@WriteActivity, "Group", 0)
        request.complete = week_overEdit + "<br>"
        request.trouble = week_helpEdit + "<br>"
        request.plane = next_weekEdit + "<br>"
        request.url = urlEdit
        val gson = Gson()
        var route = gson.toJson(request)
        //封装请求体
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        RequestUtil.observable.ISetWeekNews(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    SetNewsResponse ->
                    when(SetNewsResponse.infoCode){
                        200 -> goMain(2)
                        500 -> goMain(3)
                    }
                }
    }

    private fun saveWeekNews() {
        if (week_over.length() < 1 || week_help.length() < 1 || next_week.length() < 1) {
            Toast.makeText(this@WriteActivity, "必填项不能为空", Toast.LENGTH_SHORT).show()
        } else {
            util.putString(this@WriteActivity, "week_over", "${week_over.text}<br>")
            util.putString(this@WriteActivity, "week_help", "${week_help.text}<br>")
            util.putString(this@WriteActivity, "next_week", "${next_week.text}<br>")
            util.putString(this@WriteActivity, "url", "${url.text}<br>")
            val intent = Intent(this@WriteActivity, SavedActivity::class.java)
        }
    }
    private fun goMain(isUpData : Int){
        intent.putExtra(StaticClass.IS_UPDATANEEWS_KEY, 1)
        startActivity(intent)
    }


}
