package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.AllGroup;

import io.reactivex.Observable;

/**
 * @class name: AllGroupCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  1:14
 */
public class AllGroupCons {
    public interface View{
        void getDateSuccess(AllGroup allGroup);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<AllGroup> PostAllGroup();
    }
}
