package com.example.administrator.wuanandroids.Mvp.Model.GroupBean;

/**
 * @class name: Groupst
 * @anthor ：卫士
 * @time :Create on 2018/9/15  1:38
 */
public class Groupst {
    private int id;
    private String groupName;
    private String deleteFlg;
    private String createTime;
    private String modifyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
