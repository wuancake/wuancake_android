package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: UpdateNamePr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class UpdateNamePr {
    private UpdateNameModel updateNameModel;
    private UpdateNameCons.View view;
    public UpdateNamePr(UpdateNameModel updateNameModel,UpdateNameCons.View view){
        this.updateNameModel=updateNameModel;
        this.view=view;
    }

    public void GetDate(UpdateNameBody updateNameBody){
        Observable<GetUpateName> getUpateNameObservable=updateNameModel.PostUpdateName(updateNameBody);
        getUpateNameObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetUpateName>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUpateName getUpateName) {
                        view.getDateSuccess(getUpateName);

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
