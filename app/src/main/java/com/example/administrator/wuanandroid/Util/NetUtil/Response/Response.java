package com.example.administrator.wuanandroid.Util.NetUtil.Response;

public class Response <T> {

    /**
     * 返回code
     * @Http Code 400 - 请求参数/格式不正确
     * @Http Code 500 - 服务器内部错误
     * @Http Code 404 - 服务器不存在
     */
    private int infoCode ;

    /**
     * 具体数据Bean
     * 例如登陆接口 LoginBean.class
     */

    private T data ;

    /**
     * 接口返回说明
     * 例如：“infoText”:”修改成功（失败）
     */
    private String infoText ;


    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }




}
