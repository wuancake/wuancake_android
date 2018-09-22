package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.IndexCons;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.GetIndex;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.IndexBody;
import com.example.administrator.wuanandroids.Mvp.Model.IndexModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: IndexPr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  11:49
 */
public class IndexPr {
    private IndexModel indexModel;
    private IndexCons.View view;
    public IndexPr(IndexModel indexModel,IndexCons.View view){
        this.indexModel =indexModel;
        this.view=view;
    }
    public void GetDate(IndexBody indexBody){
        Observable<GetIndex> getIndexObservable=indexModel.PostIndex(indexBody);
        getIndexObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetIndex>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetIndex getIndex) {
                        view.getDateSuccess(getIndex);

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
