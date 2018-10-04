package wuan.nixo.com.wuan_android_v2.Model;

public class MainModel {

    /**
     * infoText : 已请假
     * infoCode : 200
     * weekNum : 138
     * status : 3
     * version : {"v":1.2,"url":"https://github.com/wuancake/wuancake_admin/releases/download/v1.2/admin_back-0.0.1-SNAPSHOT.war"}
     */

    private String infoText;
    private int infoCode;
    private int weekNum;
    private int status;
    private VersionBean version;

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

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public VersionBean getVersion() {
        return version;
    }

    public void setVersion(VersionBean version) {
        this.version = version;
    }

    public static class VersionBean {
        /**
         * v : 1.2
         * url : https://github.com/wuancake/wuancake_admin/releases/download/v1.2/admin_back-0.0.1-SNAPSHOT.war
         */

        private double v;
        private String url;

        public double getV() {
            return v;
        }

        public void setV(double v) {
            this.v = v;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
