package com.example.administrator.wuanandroid.Mvp.Model;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroid.Util.NetUtil.NetWorkManager;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: UpdatePwdModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class UpdatePwdModel implements UpdatePwdCons.Model{

    @Override
    public Observable<Response<List<GetUpdatePwd>>> PostUpdatePwd(UpdatePwdBody updatePwdBody) {
        return NetWorkManager.getRequest().PostUpdatePwd(updatePwdBody);
    }
}
