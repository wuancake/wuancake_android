package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: UpdatePwdModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class UpdatePwdModel implements UpdatePwdCons.Model{


    @Override
    public Observable<GetUpdatePwd> PostUpdatePwd(UpdatePwdBody updatePwdBody) {
        return NetWorkManager.getRequest().PostUpdatePwd(updatePwdBody);
    }
}
