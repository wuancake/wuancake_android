package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: UpdatePwdPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class UpdatePwdPr {
    private UpdatePwdModel updatePwdModel;
    private UpdatePwdCons.View view;
    public UpdatePwdPr(UpdatePwdModel updatePwdModel,UpdatePwdCons.View view){
        this.updatePwdModel=updatePwdModel;
        this.view=view;
    }

    public void GetDate(UpdatePwdBody updatePwdBody){
        Observable<GetUpdatePwd> getUpdatePwdObservable=updatePwdModel.PostUpdatePwd(updatePwdBody);
        getUpdatePwdObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetUpdatePwd>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUpdatePwd getUpdatePwd) {
                        view.getDateSuccess(getUpdatePwd);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
