package com.example.administrator.wuanandroid.Mvp.Model;

import com.example.administrator.wuanandroid.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroid.Util.NetUtil.NetWorkManager;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: QuitUnitModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class QuitUnitModel implements QuitUnitCons.Model {
    @Override
    public Observable<Response<List<GetQuitUnit>>> PostQuitUnit(QuitUnitBody quitUnitBody) {
        return NetWorkManager.getRequest().PostQuitUnit(quitUnitBody);
    }
}
