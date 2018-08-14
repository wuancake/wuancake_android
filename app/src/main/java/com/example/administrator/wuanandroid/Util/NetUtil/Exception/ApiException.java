package com.example.administrator.wuanandroid.Util.NetUtil.Exception;

public class ApiException extends Exception {

    private int code;
    private String dislayMessage;

    public ApiException(int code , String displayMessage){
        this.code = code;
        this.dislayMessage = displayMessage;
    }

    public ApiException (int code,String message , String dispalyMessage){
        super(message);
        this.code = code;
        this.dislayMessage = dispalyMessage;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDislayMessage() {
        return dislayMessage;
    }

    public void setDislayMessage(String dislayMessage) {
        this.dislayMessage = dislayMessage;
    }





}
