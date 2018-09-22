package com.example.administrator.wuanandroids.Mvp.Model.GroupBean;

/**
 * @class name: GetGroup
 * @anthor ：卫士
 * @time :Create on 2018/9/14  22:57
 */
public class GetGroup {
    private String infoText;
    private String infoCode;
    private int userId;
    private int groupId;

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
