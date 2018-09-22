package com.example.administrator.wuanandroids.Mvp.Model.GroupBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @class name: AllGroup
 * @anthor ：卫士
 * @time :Create on 2018/9/15  1:06
 */
public class AllGroup {
    private  String infoText;
    private  String infoCode;
    private  int userId;
    private int groupId;
    private String userName;
    private  int currWeek;
    private int status;
    private List<Groupst> groups=new ArrayList<>();

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

    public List<Groupst> getGroupsList() {
        return groups;
    }

    public void setGroupsList(List<Groupst> groupsList) {
        this.groups = groupsList;
    }


}
