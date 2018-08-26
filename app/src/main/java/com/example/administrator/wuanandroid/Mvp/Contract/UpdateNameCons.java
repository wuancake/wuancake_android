package com.example.administrator.wuanandroid.Mvp.Contract;

import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: UpdateNameCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:22
 */
public class UpdateNameCons {
    public interface View{
        void getDateSuccess(List<GetUpateName> getUpateNames);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<Response<List<GetUpateName>>> PostUpdateName(UpdateNameBody updateNameBody);
    }
}
