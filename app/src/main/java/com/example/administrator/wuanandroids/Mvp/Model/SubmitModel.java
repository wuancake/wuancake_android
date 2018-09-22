package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.SubmitCons;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.GetSubmit;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.SubmitBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: SubmitModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:02
 */
public class SubmitModel implements SubmitCons.Model {
    @Override
    public Observable<GetSubmit> PostSubmit(SubmitBody submitBody) {
        return NetWorkManager.getRequest().PostSubmit(submitBody);
    }
}
