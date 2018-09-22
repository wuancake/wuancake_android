package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.AllGroupCons;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.AllGroup;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: AllGroupModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  1:15
 */
public class AllGroupModel implements AllGroupCons.Model {

    @Override
    public Observable<AllGroup> PostAllGroup() {
        return NetWorkManager.getRequest().PostAllGroup();
    }
}
