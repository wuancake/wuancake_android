package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.CancelBody;
import com.example.administrator.wuanandroids.Mvp.Model.CancelBean.GetCancel;

import io.reactivex.Observable;

/**
 * @class name: CancelCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  16:24
 */
public class CancelCons {

    public interface  Model{
        public Observable<GetCancel> PostCancel(CancelBody cancelBody);
    }
}
