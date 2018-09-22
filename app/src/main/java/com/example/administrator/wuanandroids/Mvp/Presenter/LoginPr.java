package com.example.administrator.wuanandroids.Mvp.Presenter;

import android.app.ProgressDialog;

import com.example.administrator.wuanandroids.Mvp.Contract.LoginCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.GetLogin;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.LoginModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: LoginPr
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:36
 */
public class LoginPr {
    private LoginModel loginModel;
    private LoginCons.View view;
    public LoginPr(LoginModel loginModel,LoginCons.View view){
        this.loginModel=loginModel;
        this.view=view;
    }
    public void GetDate(LoginBody loginBody){
        Observable<GetLogin> getLoginObservable=loginModel.PostLogin(loginBody);
       getLoginObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetLogin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetLogin getLogin) {
                        view.getDateSuccess(getLogin);

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
