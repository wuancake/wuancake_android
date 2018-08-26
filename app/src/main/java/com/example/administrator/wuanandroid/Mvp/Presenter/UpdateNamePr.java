package com.example.administrator.wuanandroid.Mvp.Presenter;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameModel;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.ResponseTransformer;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @class name: UpdateNamePr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class UpdateNamePr {
    private UpdateNameModel updateNameModel;
    private UpdateNameCons.View view;
    private BaseSchedulerProvider schedulerProvider;
    private CompositeDisposable mDisposable;
    public UpdateNamePr(UpdateNameModel updateNameModel,UpdateNameCons.View view,BaseSchedulerProvider schedulerProvider){
        this.updateNameModel=updateNameModel;
        this.view=view;
        this.schedulerProvider=schedulerProvider;
        mDisposable=new CompositeDisposable();
    }

    public void despose(){
        mDisposable.dispose();
    }
    public void GetDate(UpdateNameBody updateNameBody){
        Disposable disposable=updateNameModel.PostUpdateName(updateNameBody)
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(new Consumer<List<GetUpateName>>() {
                    @Override
                    public void accept(List<GetUpateName> getUpateNames) throws Exception {
                        view.getDateSuccess(getUpateNames);
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
