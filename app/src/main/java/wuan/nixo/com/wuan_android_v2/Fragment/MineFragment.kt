package wuan.nixo.com.wuan_android_v2.Fragment



import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText

import wuan.nixo.com.wuan_android_v2.R
import kotlinx.android.synthetic.main.fragment_mine.*
import wuan.nixo.com.wuan_android_v2.View.ChangeNameActivity
import wuan.nixo.com.wuan_android_v2.View.ChangePwdActivity
import wuan.nixo.com.wuan_android_v2.View.ExitGroupActivity
import wuan.nixo.com.wuan_android_v2.View.LoginActivity
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil


class MineFragment : BaseFragment(), View.OnClickListener {
    override val resourceView: Int
        get() =  R.layout.fragment_mine


    override fun onClick(p0: View?) {
        when(p0){
            ll1 ->{
               startActivity(ChangeNameActivity::class.java)
            }

            ll5 ->{
                startActivity(ExitGroupActivity::class.java)
            }

            ll4->{
                startActivity(ChangePwdActivity::class.java)
            }
            logout->{
                SharedUtil().putInt(activity!!.baseContext,"userId",0)
                startActivity(LoginActivity::class.java)
                activity!!.finish()

            }

        }
    }

        override fun initView(savedInstanceState: Bundle?) {
            ll1.setOnClickListener(this)
            ll4.setOnClickListener(this)
            ll5.setOnClickListener(this)
            logout.setOnClickListener(this)
            mine_name.isFocusable = false
            mine_email.isFocusable = false
            mine_group.isFocusable = false
            mine_password.isFocusable = false
            mine_Egroup.isFocusable = false
            mine_name.setText(SharedUtil().getString(activity!!.baseContext,"name",""))
            mine_group.setText(SharedUtil().getString(activity!!.baseContext,"groupName",""))
            mine_email.setText(SharedUtil().getString(activity!!.baseContext,"email",""))
        }





}