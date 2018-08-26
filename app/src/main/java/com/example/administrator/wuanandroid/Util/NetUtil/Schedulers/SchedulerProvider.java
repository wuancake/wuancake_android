package com.example.administrator.wuanandroid.Util.NetUtil.Schedulers;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.BaseSchedulerProvider {

    @NonNull
    private  static SchedulerProvider INSTANCE;

    /**
     * 单例类构造函数
     */
    private SchedulerProvider(){}


    public static synchronized SchedulerProvider getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(io()).observeOn(ui());
    }
}
