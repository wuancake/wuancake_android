package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.GetLogin;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;

import io.reactivex.Observable;

/**
 * @class name: LoginCons
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:34
 */
public class LoginCons {
    public interface View{
        void getDateSuccess(GetLogin getLogin);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetLogin> PostLogin(LoginBody loginBody);
    }
}
