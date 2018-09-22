package com.example.administrator.wuanandroids.Mvp.Model.LoginBean;

/**
 * @class name: GetLogin
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:24
 */
public class GetLogin {
    private String infoText;
    private  String  infoCode;
    private int userId;
    private int groupId;
    private String  userName;
    private String groupName;
    private int currWeek;
    private int status;
    private String groups;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCurrWeek() {
        return currWeek;
    }

    public void setCurrWeek(int currWeek) {
        this.currWeek = currWeek;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

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
}
