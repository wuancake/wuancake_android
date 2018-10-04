package wuan.nixo.com.wuan_android_v2.Model

class GroupModel {

    /**
     * infoText : null
     * infoCode : 200
     * userId : null
     * groupId : null
     * userName : null
     * groupName : null
     * currWeek : null
     * status : null
     * groups : [{"id":1,"groupName":"PHP组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":2,"groupName":"Web前端组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":3,"groupName":"UI设计组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":4,"groupName":"Android组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":5,"groupName":"产品经理组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":6,"groupName":"软件测试组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":7,"groupName":"Java组","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":8,"groupName":"超银河系战队","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":9,"groupName":"M78星云","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":10,"groupName":"轰炸机小分队","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":11,"groupName":"人工智障","deleteFlg":null,"createTime":null,"modifyTime":null},{"id":12,"groupName":"阿姆斯特朗炮弹大队","deleteFlg":null,"createTime":null,"modifyTime":null}]
     */

    var infoText: String? = null
    var infoCode: String? = null
    var userId: Any? = null
    var groupId: Any? = null
    var userName: Any? = null
    var groupName: Any? = null
    var currWeek: Any? = null
    var status: Any? = null
    var groups: List<GroupsBean> = ArrayList()

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
