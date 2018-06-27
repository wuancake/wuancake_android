package com.example.administrator.wuanandroid.Bean.GroupBean

class AllGroupBean {
    /**
     * infoText : null
     * infoCode : 301
     * userId : null
     * groupId : null
     * groups : [{"id":1,"groupName":"PHP组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":2,"groupName":"Web前端组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":3,"groupName":"UI设计组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":4,"groupName":"Android组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":5,"groupName":"产品经理组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":6,"groupName":"软件测试组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":7,"groupName":"Java组","deleteFlg":null,"createTime":null,"modifyTime":null}]
     */

    var infoText: Any? = null
    var infoCode: String? = null
    var userId: Any? = null
    var groupId: Any? = null
    var groups: List<GroupsBean>? = null

    class GroupsBean {
        /**
         * id : 1
         * groupName : PHP组
         * deleteFlg : null
         * createTime : null
         * modifyTime : null
         */

        var id: Int = 0
        var groupName: String? = null
        var deleteFlg: Any? = null
        var createTime: Any? = null
        var modifyTime: Any? = null
    }
}
