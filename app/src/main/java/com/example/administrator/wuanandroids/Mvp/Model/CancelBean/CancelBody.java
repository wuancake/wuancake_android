package com.example.administrator.wuanandroids.Mvp.Model.CancelBean;

/**
 * @class name: CancelBody
 * @anthor ：卫士
 * @time :Create on 2018/9/15  16:20
 */
public class CancelBody {
    private int userId;
    private int groupId;
    public CancelBody(int userId,int groupId){
        this.userId=userId;
        this.groupId=groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
