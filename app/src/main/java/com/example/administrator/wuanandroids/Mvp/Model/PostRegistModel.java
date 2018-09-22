package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.RegistCons;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.GetRegist;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.RegistBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: PostRegistModel
 * @anthor ：卫士
 * @time :Create on 2018/9/14  21:20
 */
public class PostRegistModel implements RegistCons.Model {
    @Override
    public Observable<GetRegist> PostRegist(RegistBody registBody) {
        return NetWorkManager.getRequest().PostRegist(registBody);
    }
}
