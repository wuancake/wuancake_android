package com.example.administrator.wuanandroids.Util

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {


    private val mContent: Context? = null
    /**
     * 创建View
     */
    var contentView: View? = null
        private set

    /**
     * 所属Activity
     */
    private val mActivity: Activity? = null

    /**
     * 记录是否已经创建了Activity,避免重复创建
     */
    private val mViewCreated: Boolean = false

    /**
     * ButterKinfer控件绑定；
     */
    //    private Unbinder mUnbinder;

    var mContext: Context? = null
        private set

    /**
     * 是否要在销毁时取消注册掉EventBUS；
     * @return true -> 取消  \\  false ->不取消
     */
    fun mUnRegisterEventBusOnDestory(): Boolean {
        return false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView = inflater.inflate(setLayoutResourceID(), container, false)
        //        mUnbinder = ButterKnife.bind(this,mInflateView);
        mContext = context
        init()
        setUpView()
        return contentView

    }


    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    protected abstract fun setLayoutResourceID(): Int

    /**
     * 一些View的相关操作
     */
    protected abstract fun setUpView()

    /**
     * 一些Data的相关操作
     */
    protected abstract fun setUpData()

    /**
     * 此方法用于初始化成员变量及获取Intent传递过来的数据
     * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
     */
    protected abstract fun init()
}
