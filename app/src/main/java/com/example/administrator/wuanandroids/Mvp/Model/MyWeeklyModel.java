package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: MyWeeklyModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class MyWeeklyModel implements MyWeeklyCons.Model {

    @Override
    public Observable<GetMyWeekly> PostMyWeekly(MyWeeklyBody myWeeklyBody) {
        return NetWorkManager.getRequest().PostMyWeekly(myWeeklyBody);
    }
}
