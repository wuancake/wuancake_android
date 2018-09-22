package com.example.administrator.wuanandroids.Mvp.Model.RegistBean;

/**
 * @class name: GetRegist
 * @anthor ：卫士
 * @time :Create on 2018/9/14  21:15
 */
public class GetRegist {
    private String infoText;
    private String infoCode;
    private int userId;
    private int groupId;
    private String userName;
    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
