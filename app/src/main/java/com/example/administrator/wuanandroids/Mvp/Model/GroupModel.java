package com.example.administrator.wuanandroids.Mvp.Model;

import com.example.administrator.wuanandroids.Mvp.Contract.GroupCons;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GetGroup;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GroupBody;
import com.example.administrator.wuanandroids.Util.NetUtil.NetWorkManager;

import io.reactivex.Observable;

/**
 * @class name: GroupModel
 * @anthor ：卫士
 * @time :Create on 2018/9/15  7:45
 */
public class GroupModel implements GroupCons.Model {
    @Override
    public Observable<GetGroup> PostGroup(GroupBody groupBody) {
        return NetWorkManager.getRequest().PostGroup(groupBody);
    }
}
