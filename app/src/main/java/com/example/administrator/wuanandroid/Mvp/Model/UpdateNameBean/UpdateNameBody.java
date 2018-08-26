package com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean;

/**
 * @class name: UpdateNameBody
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:02
 */
public class UpdateNameBody {
    public int id;
    public String userName;
    public UpdateNameBody(int id,String userName){
        this.id=id;
        this.userName=userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
