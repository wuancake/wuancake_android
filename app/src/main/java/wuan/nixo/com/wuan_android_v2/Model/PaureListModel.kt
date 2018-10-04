package wuan.nixo.com.wuan_android_v2.Model

class PaureListModel {

    /**
     * reports : [{"userId":3,"groupId":2,"complete":"yy","trouble":"yy","plane":"yy","url":null,"text":"yy<br></br>yy<br></br>yy<br></br><br></br>","status":2,"replyTime":"2018-09-22T14:47:17.000+0000","weekNum":151}]
     * count : 3
     */

    var count: Int = 0
    var reports: List<ReportsBean> = ArrayList()

    class ReportsBean {
        /**
         * userId : 3
         * groupId : 2
         * complete : yy
         * trouble : yy
         * plane : yy
         * url : null
         * text : yy<br></br>yy<br></br>yy<br></br><br></br>
         * status : 2
         * replyTime : 2018-09-22T14:47:17.000+0000
         * weekNum : 151
         */

        var userId: Int = 0
        var groupId: Int = 0
        var complete: String? = null
        var trouble: String? = null
        var plane: String? = null
        var url: String? = null
        var text: String? = null
        var status: Int = 0
        var replyTime: String? = null
        var weekNum: Int = 0
    }
}
