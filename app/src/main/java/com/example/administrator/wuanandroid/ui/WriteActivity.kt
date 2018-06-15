package com.example.administrator.wuanandroid.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.administrator.wuanandroid.R
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.administrator.wuanandroid.Bean.setNewsBean.SetNewsRequest
import com.example.administrator.wuanandroid.Bean.setNewsBean.SetNewsResponse
import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.mView.mLoaddingDialog
import com.example.administrator.wuanandroid.utils.*
import com.example.administrator.wuanandroid.utils.StaticClass.isSave
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.content_xd.*


/**
 * isSave在Static.kt中 判断是否保存周报
 */
class WriteActivity : AppCompatActivity() ,View.OnClickListener{





    override fun onClick(v: View) {
        when(v.id){
            R.id.write_back ->finish()
            R.id.write_set ->{
                dialog!!.show()
                dialog!!.setCancelable(false)
                getWeekText()
                if(week_overEdit.isEmpty() ||week_helpEdit.isEmpty() || next_weekEdit.isEmpty()){
                    t.st("必填项不能为空")
                }else{
                    tijiao(week_overEdit!!, week_helpEdit!!, next_weekEdit!!, urlEdit)
                    var intent = Intent(this@WriteActivity,SavedActivity::class.java)
                    intent.putExtra(StaticClass.IS_UPDATANEEWS_KEY,2)
                    startActivity(intent)
                }

            }
            R.id.write_save ->{
                    saveWeekText(week_overEdit!!, week_helpEdit!!, next_weekEdit!!, urlEdit)
                    var intent = Intent(this@WriteActivity, SavedActivity::class.java)
                    intent.putExtra(StaticClass.IS_UPDATANEEWS_KEY, 1)
                    startActivity(intent)

            }
        }
    }

    var dialog : Dialog? = null
    var week_overEdit:String = ""
    var week_helpEdit:String = ""
    var next_weekEdit:String =""
    var  urlEdit:String= "."
    var util = SharedUtil()
    var l = L()
    var t = ToastUtil(this@WriteActivity)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        setSupportActionBar(toolbar)
        toolbar.setTitle("")
        write_back.setOnClickListener(this)
        write_set.setOnClickListener(this)
        write_save.setOnClickListener(this)
        ReSetWeekText(isSave)
        dialog = DialogUtil(this@WriteActivity).getLoaddingDialog()

    }

    fun ReSetWeekText(isSaved : Boolean){
        if(isSaved){
            week_help.setText(util.getString(this@WriteActivity,"week_help","."))
            week_next.setText(util.getString(this@WriteActivity,"next_week","."))
            week_over.setText(util.getString(this@WriteActivity,"week_over","."))
            url.setText(util.getString(this@WriteActivity,"week_url","."))
            isSave = false
        }
    }

    fun saveWeekText(week_over: String, week_help: String, next_week: String, url: String){
        util.putString(this@WriteActivity,"week_over",week_over+".")
        util.putString(this@WriteActivity,"week_help",week_help+".")
        util.putString(this@WriteActivity,"next_week",next_week+".")
        util.putString(this@WriteActivity,"week_url",url+".")
        isSave = true
    }


    fun getWeekText() {
        if (week_over.text.isEmpty() || week_help.text.isEmpty()|| week_next.text.isEmpty()) {
            Toast.makeText(this@WriteActivity, "必填项不能为空", Toast.LENGTH_SHORT).show()
        } else {
         week_overEdit = week_over.text.toString()
         week_helpEdit = week_help.text.toString()
         next_weekEdit = week_next.text.toString()
         urlEdit = url.text.toString()

    }
    }

    private fun tijiao(week_over: String, week_help: String, next_week: String, url: String) {
        val request = SetNewsRequest()
        //封装实体类
        request.userId = util.getInt(this@WriteActivity,StaticClass.USER_ID,1)
        request.groupId = util.getInt(this@WriteActivity, StaticClass.GROUP_ID, 0)
        request.complete = week_over + "<br>"
        request.trouble = week_help + "<br>"
        request.plane = next_week + "<br>"
        request.url =  url+"<br>"
        val gson = Gson()
        var route = gson.toJson(request)
        l.i(route)
        //封装请求体
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        RequestUtil.observable.ISetWeekNews(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    SetNewsResponse ->
                    dialog!!.dismiss()
//                    l.i("${SetNewsResponse.infoCode}"+"提交周报")
//                    l.i("${SetNewsResponse.infoText}")
                    when(SetNewsResponse.infoCode){
                        200 -> goMain(2)
                        500 -> t.st("${SetNewsResponse.infoText}")
                    }
                },{
                    dialog!!.dismiss()
                    var intent = Intent(this@WriteActivity,SavedActivity::class.java)
                    intent.putExtra(StaticClass.IS_UPDATANEEWS_KEY,2)
                    startActivity(intent)
                })
    }

    private fun saveWeekNews() {
            util.putString(this@WriteActivity, "week_over", "${week_over!!.text}<br>")
            util.putString(this@WriteActivity, "week_help", "${week_help!!.text}<br>")
            util.putString(this@WriteActivity, "next_week", "${week_next!!.text}<br>")
            util.putString(this@WriteActivity, "url", "${url!!.text}<br>")
            val intent = Intent(this@WriteActivity, SavedActivity::class.java)

    }
    private fun goMain(isUpData : Int){

        var intent = Intent(this@WriteActivity,MainActivity::class.java)
        intent.putExtra(StaticClass.IS_UPDATANEEWS_KEY, 1)
        startActivity(intent)
    }


}
