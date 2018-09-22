package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.LeaveCons;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.GetLeave;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.LeaveBody;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: LeavePr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:15
 */
public class LeavePr {
    private LeaveModel leaveModel;
    private LeaveCons.View view;
    public LeavePr(LeaveModel leaveModel,LeaveCons.View view){
        this.leaveModel=leaveModel;
        this.view=view;
    }
    public void GetDate(LeaveBody leaveBody){
        Observable<GetLeave> getLeaveObservable=leaveModel.PostLeave(leaveBody);
        getLeaveObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetLeave>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetLeave getLeave) {
                        view.getDateSuccess(getLeave);

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
