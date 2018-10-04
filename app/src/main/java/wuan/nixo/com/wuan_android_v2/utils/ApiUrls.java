package wuan.nixo.com.wuan_android_v2.utils;


/**
 * Created by zhanghongyu on 2018/6/19.
 */

public interface ApiUrls {
 //    /***************测试服务器**************** **/
//    String URLS = "http://10.21.114.94:60000/api/p2p/";
//    String URLS = "http://10.21.114.86:60000/api/p2p/";
//    String URLS = "http://10.20.133.40:60000/api/p2p/";
//    String URLS = "http://10.20.133.30:60000/api/p2p/";
    String URLS = "https://test.17ebank.com:9126/eco/mobile/p2p/api/p2p/";
//    String URLS = "http://10.20.133.30:50001/eco/mobile/p2p/api/p2p/";

//    String URLS = "http://10.21.114.38:60000/api/p2p/";

    /********************正式服务器*******************/
    //登录
    String LOGIN = URLS + "login";
    //校验绑卡验证码
    String BANKBAND = URLS + "bankBand";
    //获取大银行列表
    String GETBANKS = URLS + "getBanks";
    //发送验证码绑定银行卡
    String BANKVERIFY = URLS + "bankVerify";
    //获取资产信息
    String GETASSETINFO = URLS + "getAssetInfo";
    //获取绑定银行卡列表
    String GETBANDBANK = URLS + "getBandBanks";
    //开户行分行
    String GETBRANCHBANKS = URLS + "getBranchBanks";
    //开户行所在地二级接口（市县）、搜索开户行所在地
    String GETCITYIES = URLS + "getCityies";
    //我的投资列表
    String GETMYPLANS = URLS + "getMyPlans";
    //获取产品详情
    String GETPLANDETAIL = URLS + "getPlanDetail";
    //获取产品列表
    String GETPLANS = URLS + "getPlans";
    //获取开户行省
    String GETPROVINCES = URLS + "getProvinces";
    //获取问题
    String GETQUESTIONS = URLS + "getQuestions";
    //充值验证
    String GETRECHARGECODE = URLS + "getRechargeCode";
    //交易明细
    // TODO: 2018/9/12  完成
    String GETTRADEDETAILS = URLS + "getTradeDetails";
    //购买产品
    String INVESTPLAN = URLS + "investPlan";
    //修改登录密码
    String MODIFYLOGINPWD = URLS + "modifyLoginPwd";
    //绑定手机
    String MODIFYMOBILE = URLS + "modifyMobile";
    //修改交易密码
    String MODIFYPAYPWD = URLS + "modifyPayPwd";
    //查询实名认证
    String QUERYUSERCERT = URLS + "queryUserCert";
    //充值验证码
    String RECHARGEVERIFY = URLS + "rechargeVerify";
    //注册
    String REGIST = URLS + "regist";
    //忘记密码
    String RESETLOGINPWD = URLS + "resetLoginPwd";
    //忘记交易密码
    String RESETPAYPWD = URLS + "resetPayPwd";
    //绑定手机号码
    String SETMOBILE = URLS + "setMobile";
    //设置支付密码
    String SETPAYPASSWORD = URLS + "setPayPassword";
    //答题接口
    String SUBMITANSWERS = URLS + "submitAnswers";
    //解绑银行卡
    String UNBANDBANK = URLS + "unBandBank";
    //提现
    String WITHDRAW = URLS + "withdraw";
    //手机号验证码
    String RANDOMNUMBER = URLS + "randomnumber";
    //获取用户信息
    String GETUSERINFO = URLS + "getUserInfo";
    //设置手势密码
    String SETHANCODE = URLS + "sethandcode/sethandcode";
    //删除手势密码
    String DELECTHANCODE = URLS + "sethandcode/delecthanCode";
    //    手势密码登录
    String LOGINBYHANDCODE = URLS + "sethandcode/loginbyhandcode";
    //    协议
    String GETAGREEMENTREST = URLS + "getagreementrest";

    //失效银行卡二次绑定
    String INVALIDBANKCARD = URLS+ "InvalidBankCard";
    //设置默认银行卡
    String GETUPDATEUSERBANK = URLS+"getupdateuserbank";
    //设置忘记登录密码
    String RESETLOGINPWDSPECIAL = URLS+"resetLoginPwdSpecial";
    //提现手续费
    String GETCOMMISSION = URLS + "getcommission";
}

