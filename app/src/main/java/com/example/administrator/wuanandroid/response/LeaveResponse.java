package com.example.administrator.wuanandroid.response;

/**
 * Created by ChijinLoujue on 2018/4/27.
 */

public class LeaveResponse {
    private int userId;
    private int status;
    private String infoText;
    private int infoCode;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }
}
