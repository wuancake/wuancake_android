package com.example.administrator.wuanandroid.Util.Util.Util.Util.Util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {




    private Context mContent;
    /**
     * 创建View
     */
    private View mInflateView;

    /**
     * 所属Activity
     */
    private Activity mActivity;

    /**
     *记录是否已经创建了Activity,避免重复创建
     */
    private boolean mViewCreated;

    /**
     * 是否要在销毁时取消注册掉EventBUS；
     * @return true -> 取消  \\  false ->不取消
     */
    public boolean mUnRegisterEventBusOnDestory(){
        return false;
    }

    /**
     * ButterKinfer控件绑定；
     */
    private Unbinder mUnbinder;

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflateView = inflater.inflate(setLayoutResourceID(),container,false);
        mUnbinder = ButterKnife.bind(this,mInflateView);
        mContext = getContext();
        init();
        setUpView();
        return mInflateView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    public View getContentView() {
        return mInflateView;
    }

    public Context getMContext() {
        return mContext;
    }



    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    protected abstract int setLayoutResourceID();
    /**
     * 一些View的相关操作
     */
    protected abstract void setUpView();

    /**
     * 一些Data的相关操作
     */
    protected abstract void setUpData();

    /**
     * 此方法用于初始化成员变量及获取Intent传递过来的数据
     * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
     */
    protected abstract void init();
}
