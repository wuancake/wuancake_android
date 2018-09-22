package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: QuitUnitModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class QuitUnitModel implements QuitUnitCons.Model {
    @Override
    public Observable<GetQuitUnit> PostQuitUnit(QuitUnitBody quitUnitBody) {
        return NetWorkManager.getRequest().PostQuitUnit(quitUnitBody);
    }
}
