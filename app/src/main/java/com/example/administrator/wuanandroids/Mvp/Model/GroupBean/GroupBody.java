package com.example.administrator.wuanandroids.Mvp.Model.GroupBean;

/**
 * @class name: GroupBody
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:57
 */
public class GroupBody {
    private int userId;
    private int groupId;

    public GroupBody(int userId,int goupId){
        this.userId=userId;
        this.groupId=goupId;
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
