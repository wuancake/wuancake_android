package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.RegistCons;
import com.example.administrator.wuanandroids.Mvp.Model.PostRegistModel;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.GetRegist;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.RegistBody;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: RegistPr
 * @anthor ：卫士
 * @time :Create on 2018/9/14  21:22
 */
public class RegistPr   {
    private PostRegistModel postRegistModel;
    private RegistCons.View view;
    public RegistPr(PostRegistModel postRegistModel,RegistCons.View view){
        this.postRegistModel=postRegistModel;
        this.view=view;
    }

    public void GetDate(RegistBody registBody){
        Observable<GetRegist> getRegistObservable=postRegistModel.PostRegist(registBody);
        getRegistObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetRegist>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetRegist getRegist) {
                        view.getDateSuccess(getRegist);

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
