package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.UpdateNameBody;

import io.reactivex.Observable;

/**
 * @class name: UpdateNameCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:22
 */
public class UpdateNameCons {
    public interface View{
        void getDateSuccess(GetUpateName getUpateName);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<GetUpateName> PostUpdateName(UpdateNameBody updateNameBody);
    }
}
