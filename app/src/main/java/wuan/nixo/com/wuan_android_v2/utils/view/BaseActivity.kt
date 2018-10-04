package wuan.nixo.com.wuan_android_v2.utils.view

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

import wuan.nixo.com.wuan_android_v2.utils.HideInputUtils

abstract class BaseActivity : FragmentActivity() {


    private var mAlertDialog: AlertDialog? = null

    var isSetWindow = false


    /*********************
     * 子类实现
     */
    //获取布局文件
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        fullScreen(this);

        onBeforeSetContentView()
        setContentView(layoutId)
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    //初始化view
    protected abstract fun initView()

    /**
     * 设置layout前配置
     *
     */
    fun onBeforeSetContentView() {
        AppManager.getAppManager().addActivity(this)
        // 设置竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }
    /**
     * 设置主题
     */
    //    private void initTheme() {
    //        ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme);
    //    }


    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected fun translucentStatusBar() {

        //        StatusBarCompat.translucentStatusBar(this);
    }

    /**
     * 通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        startActivityForResult(cls, null, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    @JvmOverloads
    fun startActivity(cls: Class<*>, bundle: Bundle? = null) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }


    /**
     * 请求权限
     *
     *
     * 如果权限被拒绝过，则提示用户需要权限
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    protected fun requestPermission(permission: String, rationale: String, requestCode: Int) {
        if (shouldShowRequestPermissionRationale(permission)) {
            showAlertDialog("权限需求", rationale,
                    DialogInterface.OnClickListener { dialog, which -> requestPermissions(arrayOf(permission), requestCode) }, "确定", null, "取消")
        } else {
            requestPermissions(arrayOf(permission), requestCode)
        }
    }

    /**
     * 显示指定标题和信息的对话框
     *
     * @param title                         - 标题
     * @param message                       - 信息
     * @param onPositiveButtonClickListener - 肯定按钮监听
     * @param positiveText                  - 肯定按钮信息
     * @param onNegativeButtonClickListener - 否定按钮监听
     * @param negativeText                  - 否定按钮信息
     * @param isCancal                      - 点击范围外和back键是否取消
     */
    @JvmOverloads
    protected fun showAlertDialog(title: String?, message: String?,
                                  onPositiveButtonClickListener: DialogInterface.OnClickListener?,
                                  positiveText: String,
                                  onNegativeButtonClickListener: DialogInterface.OnClickListener?,
                                  negativeText: String, isCancal: Boolean = false) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(isCancal)
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener)
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener)
        mAlertDialog = builder.show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //    /**
    //     * 设置输入法的显示和隐藏
    //     *
    //     * @return
    //     */
    //    @Override
    //    public boolean dispatchTouchEvent(MotionEvent ev) {
    //        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
    //            View v = getCurrentFocus();
    ////            if (ShouldHideInput_util.isShouldHideInput(v, ev)) {
    ////                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    ////                if (imm != null) {
    ////                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    ////                }
    ////            }
    //        }
    //        // 必不可少，否则所有的组件都不会有TouchEvent了
    //        if (getWindow().superDispatchTouchEvent(ev)) {
    //            return true;
    //        }
    //        return onTouchEvent(ev);
    //    }
    /**
     * 设置字体大小不会随着系统更改
     * @return
     */
    override fun getResources(): Resources {
        val resources = super.getResources()
        val configuration = Configuration()
        configuration.setToDefaults()
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return resources
    }

    /**
     * 设置全屏
     *
     * @param activity
     */
    private fun fullScreen(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                val window = activity.window
                val decorView = window.decorView
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                decorView.systemUiVisibility = option
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            } else {
                val window = activity.window
                val attributes = window.attributes
                val flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                attributes.flags = attributes.flags or flagTranslucentStatus
                window.attributes = attributes
            }
        }
    }

    /**
     * 设置输入法的显示和隐藏
     *
     * @return
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (HideInputUtils.isShouldHideInput(v, ev)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(v!!.windowToken, 0)
            }
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return if (window.superDispatchTouchEvent(ev)) {
            true
        } else onTouchEvent(ev)
    }

}
/**
 * 通过Class跳转界面
 */
/**
 * 显示指定标题和信息的对话框
 *
 * @param title                         - 标题
 * @param message                       - 信息
 * @param onPositiveButtonClickListener - 肯定按钮监听
 * @param positiveText                  - 肯定按钮信息
 * @param onNegativeButtonClickListener - 否定按钮监听
 * @param negativeText                  - 否定按钮信息
 */


