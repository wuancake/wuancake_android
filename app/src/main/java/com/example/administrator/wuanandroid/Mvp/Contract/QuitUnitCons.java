package com.example.administrator.wuanandroid.Mvp.Contract;

import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: QuitUnitCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:21
 */
public class QuitUnitCons {
    public interface View{
        void getDateSuccess(List<GetQuitUnit> getQuitUnits);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<Response<List<GetQuitUnit>>> PostQuitUnit(QuitUnitBody quitUnitBody);
    }
}
