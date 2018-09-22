package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.GetSubmit;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.SubmitBody;

import io.reactivex.Observable;

/**
 * @class name: SubmitCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:01
 */
public class SubmitCons {
    public interface View{
        void getDateSuccess(GetSubmit getSubmit);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetSubmit> PostSubmit(SubmitBody submitBody);
    }
}
