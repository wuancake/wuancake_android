package com.example.administrator.wuanandroids.Mvp.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.CancelBody;
import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.GetCancel;
import com.example.administrator.wuanandroids.Mvp.Model.CancelModel;
import com.example.administrator.wuanandroids.Mvp.View.IndexActivity;
import com.example.administrator.wuanandroids.Tool.PreUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: CancelPr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  16:29
 */
public class CancelPr {
    private CancelModel cancelModel;
    public CancelPr(CancelModel cancelModel){
        this.cancelModel=cancelModel;
    }
    public void GetDate(CancelBody cancelBody, Context context, Activity activity){
        Observable<GetCancel> getCancelObservable=cancelModel.PostCancel(cancelBody);
        getCancelObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetCancel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCancel getCancel) {
                        if (getCancel.getInfoCode()==200){
                            PreUtils.INSTANCE.setInt(context,"status",1);
                            Toast.makeText(context,getCancel.getInfoText(),Toast.LENGTH_SHORT).show();
                            //重建indexActivity
                            activity.finish();
                            context.startActivity(new Intent(context,IndexActivity.class));
                        }else{
                            Toast.makeText(context,getCancel.getInfoText(),Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context,"网络错误！",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
