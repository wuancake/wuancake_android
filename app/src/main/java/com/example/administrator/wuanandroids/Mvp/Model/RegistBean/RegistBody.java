package com.example.administrator.wuanandroids.Mvp.Model.RegistBean;

/**
 * @class name: RegistBody
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:16
 */
public class RegistBody {
    private String userName;
    private String email;
    private String qq;
    private String password;
    public RegistBody(String userName,String email,String qq,String password){
        this.userName=userName;
        this.email=email;
        this.qq=qq;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
