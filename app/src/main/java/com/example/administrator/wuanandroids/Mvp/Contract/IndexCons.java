package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.GetIndex;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.IndexBody;

import io.reactivex.Observable;

/**
 * @class name: IndexCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  11:48
 */
public class IndexCons {
    public interface View{
        void getDateSuccess(GetIndex getIndex);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetIndex> PostIndex(IndexBody indexBody);
    }
}
