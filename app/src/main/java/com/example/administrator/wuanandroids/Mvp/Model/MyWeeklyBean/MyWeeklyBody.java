package com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean;

/**
 * @class name: MyWeeklyBody
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:57
 */
public class MyWeeklyBody {
    public int userId;
    public int groupId;
    public  int pageNum;
    public int weekNum;
    public MyWeeklyBody(int userId,int groupId,int pageNum,int weekNum){
        this.userId=userId;
        this.weekNum=weekNum;
        this.groupId=groupId;
        this.pageNum=pageNum;

    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }
}
