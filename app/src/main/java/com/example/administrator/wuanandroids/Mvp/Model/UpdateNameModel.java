package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: UpdateNameModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class UpdateNameModel implements UpdateNameCons.Model {


    @Override
    public Observable<GetUpateName> PostUpdateName(UpdateNameBody updateNameBody) {
        return NetWorkManager.getRequest().PostUpdateName(updateNameBody);
    }
}
