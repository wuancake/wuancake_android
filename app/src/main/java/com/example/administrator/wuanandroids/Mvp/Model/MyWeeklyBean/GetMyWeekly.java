package com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @class name: GetMyWeekly
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:54
 */
public class GetMyWeekly  {
    private String infoText;
    private  int infoCode;

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

    private List<Reports> reports=new ArrayList<>();
    private  int count;

    public List<Reports> getReports() {
        return reports;
    }

    public void setReports(List<Reports> reports) {
        this.reports = reports;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * "userId": 3,
     "groupId": 3,
     "complete":null,
     "trouble": null,
     "plane": null,
     "url": null,
     "text": "这是请假的",
     "status": 3,
     "replyTime": "2018-06-27T07:22:43.000+0000",
     "weekNum": 136
     */
    public class  Reports{
         private int userId;
         private int getUserId;
         private String complete;
         private String trouble;
         private String plane;
         private String url;
         private String text;
         private int status;
         private String replyTime;
         private int weekNum;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getGetUserId() {
            return getUserId;
        }

        public void setGetUserId(int getUserId) {
            this.getUserId = getUserId;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(String replyTime) {
            this.replyTime = replyTime;
        }

        public int getWeekNum() {
            return weekNum;
        }

        public void setWeekNum(int weekNum) {
            this.weekNum = weekNum;
        }
    }
}
