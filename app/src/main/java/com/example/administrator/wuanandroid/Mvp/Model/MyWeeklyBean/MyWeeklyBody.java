package com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean;

/**
 * @class name: MyWeeklyBody
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:57
 */
public class MyWeeklyBody {
    public int userId;
    public int weekNum;
    public MyWeeklyBody(int userId,int weekNum){
        this.userId=userId;
        this.weekNum=weekNum;

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
