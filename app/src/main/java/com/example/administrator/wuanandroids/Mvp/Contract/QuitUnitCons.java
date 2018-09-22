package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.QuitUnitBody;

import io.reactivex.Observable;

/**
 * @class name: QuitUnitCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:21
 */
public class QuitUnitCons {
    public interface View{
        void getDateSuccess(GetQuitUnit getQuitUnits);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetQuitUnit> PostQuitUnit(QuitUnitBody quitUnitBody);
    }
}
