package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.UpdatePwdBody;

import io.reactivex.Observable;

/**
 * @class name: UpdatePwdCons
 * @anthor ：卫士
 * @time :Create on 2018/8/26  3:22
 */
public class UpdatePwdCons {
    public interface View{
        void getDateSuccess(GetUpdatePwd getUpdatePwd);
        void getDataFail(Throwable throwable);
    }
    public interface Model{
        public Observable<GetUpdatePwd> PostUpdatePwd(UpdatePwdBody updatePwdBody);
    }
}
