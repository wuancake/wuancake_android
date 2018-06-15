package com.example.administrator.wuanandroid.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.EditText
import com.example.administrator.wuanandroid.Bean.LeaveBean.LeaveRequest
import com.example.administrator.wuanandroid.Bean.LeaveBean.LeaveResponse

import com.example.administrator.wuanandroid.MainActivity
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.*
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_leave.*
import okhttp3.RequestBody

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaveActivity : AppCompatActivity(), View.OnClickListener {

    private var weekamount = 0
    var sharedUtil  = SharedUtil()
    var t = ToastUtil(this@LeaveActivity)
    var l = L()
    var dialog : Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave)
        btnLeaveReturn.setOnClickListener(this)
        btnLeaveWeekAmount1.setOnClickListener(this)
        btnLeaveWeekAmount2.setOnClickListener(this)
        btnLeaveWeekAmount3.setOnClickListener(this)
        btnLeaveSubmit.setOnClickListener(this)
        tvWeekNumber.text = sharedUtil.getInt(this@LeaveActivity,StaticClass.WEEK_NUM,1).toString()+"周"
        dialog = DialogUtil(this@LeaveActivity).getLoaddingDialog()


    }



    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnLeaveReturn -> leaveToMain()
            R.id.btnLeaveWeekAmount1 -> {
                weekamount = 1
                btnLeaveWeekAmount1.setBackgroundColor(Color.parseColor("#B4EEB4"))
                btnLeaveWeekAmount2.setBackgroundColor(Color.parseColor("#2f94ff"))
                btnLeaveWeekAmount3.setBackgroundColor(Color.parseColor("#2f94ff"))
                l.d("1")
            }
            R.id.btnLeaveWeekAmount2 ->{
                weekamount = 2
                btnLeaveWeekAmount1.setBackgroundColor(Color.parseColor("#2f94ff"))
                btnLeaveWeekAmount2.setBackgroundColor(Color.parseColor("#B4EEB4"))
                btnLeaveWeekAmount3.setBackgroundColor(Color.parseColor("#2f94ff"))
                l.d("2")
            }
            R.id.btnLeaveWeekAmount3 -> {
                weekamount = 3
                btnLeaveWeekAmount1.setBackgroundColor(Color.parseColor("#2f94ff"))
                btnLeaveWeekAmount2.setBackgroundColor(Color.parseColor("#2f94ff"))
                btnLeaveWeekAmount3.setBackgroundColor(Color.parseColor("#B4EEB4"))
                l.d("3")
            }

            R.id.btnLeaveSubmit -> btnLeaveSubmit()
        }
    }

    private fun btnLeaveSubmit() {
        if (weekamount == 0)
            Toast.makeText(applicationContext, "请选择请假周数", Toast.LENGTH_SHORT).show()
        else if (etLeaveReason.text.toString().isEmpty())
            Toast.makeText(applicationContext, "请填写请假理由", Toast.LENGTH_SHORT).show()
        else
            netRequest()
    }

    private fun netRequest() {
        dialog!!.show()
        dialog!!.setCancelable(false)
        var leave = LeaveRequest()
        leave.groupId = sharedUtil.getInt(this@LeaveActivity,StaticClass.GROUP_ID,0)
        leave.reason = etLeaveReason.text.toString()
        leave.userId = sharedUtil.getInt(this@LeaveActivity,StaticClass.USER_ID,0)
        leave.weekNum = weekamount
        var gson = Gson()
        var route = gson.toJson(leave)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route)
        RequestUtil.observable.ILeave(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    LeaveResponse ->
                    dialog!!.dismiss()
                    when(LeaveResponse.infoCode){
                        200 -> {
                            t.st(LeaveResponse.infoText)
                            leaveToMain()
                        }
                        500 -> t.st(LeaveResponse.infoText)
                    }
                },{
                    dialog!!.dismiss()
                    t.st("提交周报失败")
                })
    }

    private fun leaveToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}