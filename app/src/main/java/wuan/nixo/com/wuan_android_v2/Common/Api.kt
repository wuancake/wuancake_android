package wuan.nixo.com.wuan_android_v2.Common

object Api{

    //-------------------服务器URL------------------//
    val baseUrl = "http://13.125.249.52:8008/"
    //---------------------------------------------//


    //--------------------接口--------------------//

    //登陆
    val LOGIN = baseUrl+"login"
    //注册
    val REGISTER = baseUrl+"regist"
    //获取分组列表
    val FINDALLGROUPINFO = baseUrl+"findAllGroupInfo"
    //选择分组
    val GROUP = baseUrl+"group"
    //首页
    val MAIN = baseUrl+"main"
    //提交周报
    val SUBMIT = baseUrl+"submit"
    //提交请假
    val LEAVE = baseUrl+"leave"
    //取消请假
    val CANCELLEAVE = baseUrl+"cancelLeave"
    //周报列表
    val MYWEEKLY = baseUrl+"myweekly"
    //修改用户名
    val UPDATEUSERNAME = baseUrl+"updateUserName"
    //修改PWD
    val UPDATEPASSWORD = baseUrl+"updatePassword"



}
