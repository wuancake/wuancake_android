package com.example.administrator.wuanandroids.Mvp.Model.LoginBean;

/**
 * @class name: LoginBody
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:25
 */
public class LoginBody {
    private String email;
    private String password;
    public LoginBody(String email,String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
