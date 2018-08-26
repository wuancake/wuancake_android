package com.example.administrator.wuanandroid.Mvp.Presenter;

import com.example.administrator.wuanandroid.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyModel;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.ResponseTransformer;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @class name: MyWeeklyPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class MyWeeklyPr {
    private MyWeeklyModel myWeeklyModel;
    private MyWeeklyCons.View view;
    private BaseSchedulerProvider schedulerProvider;
    private CompositeDisposable mDisposable;
    public MyWeeklyPr(MyWeeklyModel myWeeklyModel,MyWeeklyCons.View view,BaseSchedulerProvider schedulerProvider){
        this.myWeeklyModel=myWeeklyModel;
        this.view=view;
        this.schedulerProvider=schedulerProvider;
        mDisposable=new CompositeDisposable();
    }

    public void despose(){
        mDisposable.dispose();
    }
    public void GetDate( MyWeeklyBody myWeeklyBody){
        Disposable disposable=myWeeklyModel.PostMyWeekly(myWeeklyBody)
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(new Consumer<List<GetMyWeekly>>() {
                    @Override
                    public void accept(List<GetMyWeekly> getMyWeeklies) throws Exception {
                        view.getDateSuccess( getMyWeeklies);
                    }


                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.getDataFail(throwable);
                    }
                });

        mDisposable.add(disposable);
    }
}
