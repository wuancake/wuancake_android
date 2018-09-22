package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.IndexCons;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.GetIndex;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.IndexBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: IndexModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  11:49
 */
public class IndexModel implements IndexCons.Model {
    @Override
    public Observable<GetIndex> PostIndex(IndexBody indexBody) {
        return NetWorkManager.getRequest().PostIndex(indexBody);
    }
}
