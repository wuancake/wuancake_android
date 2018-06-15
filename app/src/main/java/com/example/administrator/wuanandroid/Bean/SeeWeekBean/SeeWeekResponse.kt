package com.example.administrator.wuanandroid.Bean.SeeWeekBean

class SeeWeekResponse {


    /**
     * reports : [{"userId":3,"groupId":3,"complete":"成","trouble":"困难","plane":"计划","url":"a","text":"完成<br></br>困难<br></br>计划<br></br><br></br>","status":2,"replyTime":1528898723000,"weekNum":137}]
     * count : 1
     */

    var count: Int = 0
    var reports: List<ReportsBean>? = null

    class ReportsBean {
        /**
         * userId : 3
         * groupId : 3
         * complete : 成
         * trouble : 困难
         * plane : 计划
         * url : a
         * text : 完成<br></br>困难<br></br>计划<br></br><br></br>
         * status : 2
         * replyTime : 1528898723000
         * weekNum : 137
         */

        var userId: Int = 0
        var groupId: Int = 0
        var complete: String? = null
        var trouble: String? = null
        var plane: String? = null
        var url: String? = null
        var text: String? = null
        var status: Int = 0
        var replyTime: Long = 0
        var weekNum: Int = 0
    }
}
