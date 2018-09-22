package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.CancelCons;
import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.CancelBody;
import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.GetCancel;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: CancelModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  16:28
 */
public class CancelModel implements CancelCons.Model {
    @Override
    public Observable<GetCancel> PostCancel(CancelBody cancelBody) {
        return NetWorkManager.getRequest().PostCancel(cancelBody);
    }
}
