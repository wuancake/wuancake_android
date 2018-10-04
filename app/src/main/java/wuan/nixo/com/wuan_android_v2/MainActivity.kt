package wuan.nixo.com.wuan_android_v2

import android.util.Log
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*

import wuan.nixo.com.wuan_android_v2.Ext.SharedExt
import wuan.nixo.com.wuan_android_v2.Ext.pref
import wuan.nixo.com.wuan_android_v2.Fragment.CommitFragment
import wuan.nixo.com.wuan_android_v2.Fragment.MineFragment
import wuan.nixo.com.wuan_android_v2.Fragment.PaureListFragment
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity

class MainActivity : BaseActivity() , BottomNavigationBar.OnTabSelectedListener{
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun initView() {

        var userId = SharedUtil().getInt(this,"userId",0)


        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_SHIFTING)

        bottom_navigation_bar
                .addItem(BottomNavigationItem(R.mipmap.frist,"首页"))
                .addItem(BottomNavigationItem(R.mipmap.paper,"周报"))
                .addItem(BottomNavigationItem(R.mipmap.me,"我的"))
                .setFirstSelectedPosition(0)
                .initialise()
        bottom_navigation_bar.setTabSelectedListener(this)
        onTabSelected(0)

    }

    private fun getMainInfo(){

    }

    override fun onTabUnselected(position: Int) {

    }
    override fun onTabReselected(position: Int) {}


    override fun onTabSelected(position: Int) {
        supportFragmentManager.beginTransaction().apply {
            when (position) {
                0 -> {
                    replace(R.id.main_fragment, CommitFragment())
                }
                1 -> {
                    replace(R.id.main_fragment, PaureListFragment())
                }
                2 -> {
                    replace(R.id.main_fragment, MineFragment())
                }
            }
        }.commitAllowingStateLoss()
    }


}
