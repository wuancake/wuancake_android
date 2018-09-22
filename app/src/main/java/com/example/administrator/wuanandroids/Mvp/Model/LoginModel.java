package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.LoginCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.GetLogin;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: LoginModel
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:35
 */
public class LoginModel implements LoginCons.Model {
    @Override
    public Observable<GetLogin> PostLogin(LoginBody loginBody) {
        return NetWorkManager.getRequest().PostLogin(loginBody);
    }
}
