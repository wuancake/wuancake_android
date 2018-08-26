package com.example.administrator.wuanandroid.Mvp.Presenter;

import com.example.administrator.wuanandroid.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitModel;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.ResponseTransformer;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @class name: QuitUnitPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class QuitUnitPr {
    private QuitUnitModel quitUnitModel;
    private QuitUnitCons.View view;
    private BaseSchedulerProvider schedulerProvider;
    private CompositeDisposable mDisposable;
    public QuitUnitPr(QuitUnitModel quitUnitModel,QuitUnitCons.View view,BaseSchedulerProvider schedulerProvider){
        this.quitUnitModel=quitUnitModel;
        this.view=view;
        this.schedulerProvider=schedulerProvider;
        mDisposable=new CompositeDisposable();
    }

    public void despose(){
        mDisposable.dispose();
    }
    public void GetDate(QuitUnitBody quitUnitBody){
        Disposable disposable=quitUnitModel.PostQuitUnit(quitUnitBody)
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(new Consumer<List<GetQuitUnit>>() {
                    @Override
                    public void accept(List<GetQuitUnit> getQuitUnits) throws Exception {
                        view.getDateSuccess(getQuitUnits);
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
