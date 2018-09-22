package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.AllGroupCons;
import com.example.administrator.wuanandroids.Mvp.Model.AllGroupModel;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.AllGroup;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: AllGroupPr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  1:17
 */
public class AllGroupPr {
    private AllGroupModel allGroupModel;
    private AllGroupCons.View view;
    public AllGroupPr(AllGroupModel allGroupModel,AllGroupCons.View view){
        this.allGroupModel=allGroupModel;
        this.view=view;
    }
    public void GetDate(){
        Observable<AllGroup> groupObservable=allGroupModel.PostAllGroup();
        groupObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AllGroup>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(AllGroup allGroup) {
                        view.getDateSuccess(allGroup);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
}}
