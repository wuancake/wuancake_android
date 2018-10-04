package wuan.nixo.com.wuan_android_v2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_exit_group.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Common.Api
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.App
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity
import java.lang.Exception

class ExitGroupActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_exit_group

    override fun initView() {
        tv_title.text = "退出分组"
        iv_back.setOnClickListener { finish()}
        egroup_set.setOnClickListener {
            var map = HashMap<String,Any>()
            map.put("id", SharedUtil().getInt(this@ExitGroupActivity,"userId",0))

            MyOkHttpUtils.postJson().json(map).url(Api.UPDATEPASSWORD).build().execute(object : StringCallback() {
                override fun onResponse(response: String?, id: Int) {
                    var bean = Gson().fromJson(response, BaseModel::class.java)
                    ToastUtils.newToastCenter(this@ExitGroupActivity,bean.infoText)
                    System.exit(0)
                }

                override fun onError(call: Call?, e: Exception?, id: Int) {
                    ToastUtils.newToastCenter(this@ExitGroupActivity,"网络连接失败")
                }
            })
        }
    }


}
