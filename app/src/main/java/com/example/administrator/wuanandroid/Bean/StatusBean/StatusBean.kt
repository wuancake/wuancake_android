package com.example.administrator.wuanandroid.Bean.StatusBean

class StatusBean {
    /**
     * infoText : 已请假
     * infoCode : 200
     * weekNum : 138
     * status : 3
     * version : {"v":1.2,"url":"https://github.com/wuancake/wuancake_admin/releases/download/v1.2/admin_back-0.0.1-SNAPSHOT.war"}
     */

    var infoText: String? = null
    var infoCode: Int = 0
    var weekNum: Int = 0
    var status: Int = 0
    var version: VersionBean? = null

    class VersionBean {
        /**
         * v : 1.2
         * url : https://github.com/wuancake/wuancake_admin/releases/download/v1.2/admin_back-0.0.1-SNAPSHOT.war
         */

        var v: Double = 0.toDouble()
        var url: String? = null
    }
}
