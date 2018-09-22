package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.GetRegist;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.RegistBody;

import io.reactivex.Observable;

/**
 * @class name: RegistCons
 * @anthor ：卫士
 * @time :Create on 2018/9/14  21:14
 */
public class RegistCons {
    public interface View{
        void getDateSuccess(GetRegist getRegist);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetRegist> PostRegist(RegistBody registBody);
    }
}
