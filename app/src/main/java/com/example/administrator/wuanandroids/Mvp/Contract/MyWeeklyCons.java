package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.MyWeeklyBody;

import io.reactivex.Observable;

/**
 * @class name: MyWeeklyCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:19
 */
public class MyWeeklyCons {
    public interface View{
        void getDateSuccess(GetMyWeekly getMyWeekly);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<GetMyWeekly> PostMyWeekly(MyWeeklyBody myWeeklyBody);
    }
}
