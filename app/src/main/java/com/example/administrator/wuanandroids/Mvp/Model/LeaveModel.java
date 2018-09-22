package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.LeaveCons;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.GetLeave;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.LeaveBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: LeaveModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:14
 */
public class LeaveModel implements LeaveCons.Model {

    @Override
    public Observable<GetLeave> PostLeave(LeaveBody leaveBody) {
        return NetWorkManager.getRequest().PostLeave(leaveBody);
    }
}
