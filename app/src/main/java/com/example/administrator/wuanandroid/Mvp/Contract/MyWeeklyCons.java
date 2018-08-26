package com.example.administrator.wuanandroid.Mvp.Contract;

import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: MyWeeklyCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:19
 */
public class MyWeeklyCons {
    public interface View{
        void getDateSuccess(List<GetMyWeekly> getMyWeeklies);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<Response<List<GetMyWeekly>>> PostMyWeekly(MyWeeklyBody myWeeklyBody);
    }
}
