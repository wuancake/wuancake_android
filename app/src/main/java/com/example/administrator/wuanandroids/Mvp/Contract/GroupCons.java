package com.example.administrator.wuanandroids.Mvp.Contract;

import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GetGroup;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GroupBody;

import io.reactivex.Observable;

/**
 * @class name: GroupCons
 * @anthor ：卫士
 * @time :Create on 2018/9/15  7:43
 */
public class GroupCons {
    public interface View{
        void getDateSuccess(GetGroup getGroup);
        void getDataFail(Throwable throwable);
    }
    public interface  Model{
        public Observable<GetGroup> PostGroup(GroupBody groupBody);
    }
}
