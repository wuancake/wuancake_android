package com.example.administrator.wuanandroid.Mvp.Presenter;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdModel;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.ResponseTransformer;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @class name: UpdatePwdPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class UpdatePwdPr {
    private UpdatePwdModel updatePwdModel;
    private UpdatePwdCons.View view;
    private BaseSchedulerProvider schedulerProvider;
    private CompositeDisposable mDisposable;
    public UpdatePwdPr(UpdatePwdModel updatePwdModel,UpdatePwdCons.View view,BaseSchedulerProvider schedulerProvider){
        this.updatePwdModel=updatePwdModel;
        this.view=view;
        this.schedulerProvider=schedulerProvider;
        mDisposable=new CompositeDisposable();
    }

    public void despose(){
        mDisposable.dispose();
    }
    public void GetDate(UpdatePwdBody updatePwdBody){
        Disposable disposable=updatePwdModel.PostUpdatePwd(updatePwdBody)
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(new Consumer<List<GetUpdatePwd>>() {
                    @Override
                    public void accept(List<GetUpdatePwd> getUpdatePwds) throws Exception {
                        view.getDateSuccess(getUpdatePwds);
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
