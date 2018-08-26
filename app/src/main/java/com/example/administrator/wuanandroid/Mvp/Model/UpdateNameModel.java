package com.example.administrator.wuanandroid.Mvp.Model;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroid.Util.NetUtil.NetWorkManager;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: UpdateNameModel
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:25
 */
public class UpdateNameModel implements UpdateNameCons.Model {

    @Override
    public Observable<Response<List<GetUpateName>>> PostUpdateName(UpdateNameBody updateNameBody) {
        return NetWorkManager.getRequest().PostUpdateName(updateNameBody);
    }
}
