package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.GetLeave;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.LeaveBody;

import io.reactivex.Observable;

/**
 * @class name: LeaveCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  12:13
 */
public class LeaveCons {
    public interface View{
        void getDateSuccess(GetLeave getLeave);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetLeave> PostLeave(LeaveBody leaveBody);
    }
}
