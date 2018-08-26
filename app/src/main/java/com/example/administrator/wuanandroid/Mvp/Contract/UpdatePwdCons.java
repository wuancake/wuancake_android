package com.example.administrator.wuanandroid.Mvp.Contract;

import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroid.Util.NetUtil.Response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * @class name: UpdatePwdCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:22
 */
public class UpdatePwdCons {
    public interface View{
        void getDateSuccess(List<GetUpdatePwd> getUpdatePwds);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<Response<List<GetUpdatePwd>>> PostUpdatePwd(UpdatePwdBody updatePwdBody);
    }
}
