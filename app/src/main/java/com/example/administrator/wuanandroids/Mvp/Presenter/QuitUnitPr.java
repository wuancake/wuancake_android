package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: QuitUnitPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class QuitUnitPr {
    private QuitUnitModel quitUnitModel;
    private QuitUnitCons.View view;
    public QuitUnitPr(QuitUnitModel quitUnitModel,QuitUnitCons.View view){
        this.quitUnitModel=quitUnitModel;
        this.view=view;
    }

    public void GetDate(QuitUnitBody quitUnitBody){
        Observable<GetQuitUnit> getQuitUnitObservable=quitUnitModel.PostQuitUnit(quitUnitBody);
               getQuitUnitObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetQuitUnit>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetQuitUnit getQuitUnit) {
                        view.getDateSuccess(getQuitUnit);

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
