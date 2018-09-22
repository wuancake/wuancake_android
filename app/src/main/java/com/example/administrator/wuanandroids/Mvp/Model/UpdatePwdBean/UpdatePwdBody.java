package com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean;

/**
 * @class name: UpdatePwdBody
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:04
 */
public class UpdatePwdBody {
    public int userId;
    public String password;
    public String newPassword;
    public String confirmPasswd;
    public  UpdatePwdBody(int userId,String password,String newPassword,String confirmPasswd){
        this.userId=userId;
        this.password=password;
        this.newPassword=newPassword;
        this.confirmPasswd=confirmPasswd;
    }

    public String getConfirmPasswd() {
        return confirmPasswd;
    }

    public void setConfirmPasswd(String confirmPasswd) {
        this.confirmPasswd = confirmPasswd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
