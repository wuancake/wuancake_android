package com.example.administrator.wuanandroids.Mvp.Model.IndexBean;

/**
 * @class name: IndexBody
 * @anthor ：卫士
 * @time :Create on 2018/9/15  10:21
 */
public class IndexBody {
    private  int userId;
    public IndexBody(int userId){
        this.userId=userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
