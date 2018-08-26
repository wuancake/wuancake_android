package com.example.administrator.wuanandroid.Mvp.Model;

import com.example.administrator.wuanandroid.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Util.NetUtil.NetWorkManager;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: MyWeeklyModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class MyWeeklyModel implements MyWeeklyCons.Model {
    @Override
    public Observable<Response<List<GetMyWeekly>>> PostMyWeekly(MyWeeklyBody myWeeklyBody) {
        return NetWorkManager.getRequest().PostMyWeekly(myWeeklyBody);
    }
}
