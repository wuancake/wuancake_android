package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: MyWeeklyPr
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:36
 */
public class MyWeeklyPr {
    private MyWeeklyModel myWeeklyModel;
    private MyWeeklyCons.View view;
    public MyWeeklyPr(MyWeeklyModel myWeeklyModel,MyWeeklyCons.View view){
        this.myWeeklyModel=myWeeklyModel;
        this.view=view;
    }

    public void GetDate(MyWeeklyBody myWeeklyBody){
        Observable<GetMyWeekly> getMyWeeklyObservable=myWeeklyModel.PostMyWeekly(myWeeklyBody);
        getMyWeeklyObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetMyWeekly>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMyWeekly getMyWeekly) {
                        view.getDateSuccess(getMyWeekly);

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
