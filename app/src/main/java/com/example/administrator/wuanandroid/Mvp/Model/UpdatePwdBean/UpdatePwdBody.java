package com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean;

/**
 * @class name: UpdatePwdBody
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:04
 */
public class UpdatePwdBody {
    public int userId;
    public String password;
    public String newPassword;
    public String confirmPassword;
    public UpdatePwdBody(int userId,String password,String newPassword,String confirmPassword){
        this.userId=userId;
        this.password=password;
        this.newPassword=newPassword;
        this.confirmPassword=confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
