package com.example.administrator.wuanandroids.Mvp.Model.LeaveBean;

/**
 * @class name: LeaveBody
 * @anthor ：卫士
 * @time :Create on 2018/9/15  10:13
 */
public class LeaveBody {
    private int userId;
    private int groupId;
    private int weekNum;
    private String reason;

    public LeaveBody(int userId,int groupId ,int weekNum,String reason){
        this.userId=userId;
        this.groupId=groupId;
        this.weekNum=weekNum;
        this.reason=reason;
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

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
