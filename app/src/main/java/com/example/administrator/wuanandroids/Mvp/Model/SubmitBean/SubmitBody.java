package com.example.administrator.wuanandroids.Mvp.Model.SubmitBean;

/**
 * @class name: SubmitBody
 * @anthor ：卫士
 * @time :Create on 2018/9/15  10:13
 */
public class SubmitBody {
    private int userId;
    private  int groupId;
    private String complete;
    private String trouble;
    private String plane;
    private  String url;

    public SubmitBody(int userId,int groupId,String complete,String trouble,String plane,String url){
        this.userId=userId;
        this.complete=complete;
        this.trouble=trouble;
        this.plane=plane;
        this.groupId=groupId;
        this.url=url;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getTrouble() {
        return trouble;
    }

    public void setTrouble(String trouble) {
        this.trouble = trouble;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

}
