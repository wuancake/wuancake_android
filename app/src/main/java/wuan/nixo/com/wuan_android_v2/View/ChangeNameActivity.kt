package wuan.nixo.com.wuan_android_v2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_change_name.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api.UPDATEUSERNAME
import wuan.nixo.com.wuan_android_v2.Ext.isNull
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity
import java.lang.Exception

class ChangeNameActivity:BaseActivity() , View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0){

            name_set->{
                (et_newname.text.toString().isNull()).yes {
                    ToastUtils.newToastCenter(this@ChangeNameActivity,"请输入新昵称")
                }.otherwise {
                    changeName(et_newname.text.toString())
                }
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_change_name

    override fun initView() {
        tv_title.text = "修改昵称"
        iv_back.setOnClickListener { finish() }

        et_newname.setOnClickListener(this)
        name_set.setOnClickListener(this)
    }

    private fun changeName(name : String){
        var map = HashMap<String,Any>()
        map.put("id",SharedUtil().getInt(this@ChangeNameActivity,"userId",0))
        map.put("userName",name)
        MyOkHttpUtils.postJson().json(map).url(UPDATEUSERNAME).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                Log.i("Nixo","---------修改昵称response-------$response")
                var bean = Gson().fromJson(response,BaseModel::class.java)
                (bean.infoCode == "200").yes{
                    SharedUtil().putString(this@ChangeNameActivity,"name","${bean.userName}")
                }
                ToastUtils.newToastCenter(this@ChangeNameActivity,bean.infoText)
                finish()
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                ToastUtils.newToastCenter(this@ChangeNameActivity,"网络连接失败")
            }
        })
    }


}
