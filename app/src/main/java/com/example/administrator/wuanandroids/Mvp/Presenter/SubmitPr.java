package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.SubmitCons;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.GetSubmit;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.SubmitBody;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: SubmitPr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:02
 */
public class SubmitPr {
    private SubmitModel submitModel;
    private SubmitCons.View view;
    public SubmitPr(SubmitModel submitModel,SubmitCons.View view){
        this.submitModel=submitModel;
        this.view=view;
    }
    public void GetDate(SubmitBody submitBody){
        Observable<GetSubmit> getSubmitObservable=submitModel.PostSubmit(submitBody);
        getSubmitObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetSubmit>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetSubmit getSubmit) {
                        view.getDateSuccess(getSubmit);

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
