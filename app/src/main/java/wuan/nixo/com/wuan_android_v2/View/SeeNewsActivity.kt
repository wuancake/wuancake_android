package wuan.nixo.com.wuan_android_v2.View
import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import kotlinx.android.synthetic.main.activity_see_news.*
import kotlinx.android.synthetic.main.toolbar.*
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.R.layout.toolbar
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity

class SeeNewsActivity : BaseActivity(){
    override val layoutId: Int
        get() = R.layout.activity_see_news

    override fun initView() {
        week_over.inputType = InputType.TYPE_NULL
        week_next.inputType = InputType.TYPE_NULL
        week_wenti.inputType = InputType.TYPE_NULL
        week_url.inputType = InputType.TYPE_NULL
        tv_title.text = "查看周报"
        iv_back.setOnClickListener { finish() }
        var intent = this@SeeNewsActivity.intent
        var status = intent.getStringExtra("status")
        ("3" == status).yes{
            tv_qingjia.visibility = View.VISIBLE
            sv_weiqingjia.visibility = View.GONE
        }.otherwise {
            tv_qingjia.visibility = View.GONE
            sv_weiqingjia.visibility = View.VISIBLE
            week_over!!.setText(intent.getStringExtra("over"))
            week_next!!.setText(intent.getStringExtra("next"))
            week_wenti!!.setText(intent.getStringExtra("wenti"))
            week_url!!.setText(intent.getStringExtra("url"))
        }

    }



}
