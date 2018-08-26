package com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @class name: GetUpateName
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:00
 */
public class GetUpateName implements Parcelable {
    public String infoText;
    public String infoCode;
    public String userName;

    protected GetUpateName(Parcel in) {
        infoText = in.readString();
        infoCode = in.readString();
        userName = in.readString();
    }

    public static final Creator<GetUpateName> CREATOR = new Creator<GetUpateName>() {
        @Override
        public GetUpateName createFromParcel(Parcel in) {
            return new GetUpateName(in);
        }

        @Override
        public GetUpateName[] newArray(int size) {
            return new GetUpateName[size];
        }
    };

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(infoText);
        parcel.writeString(infoCode);
        parcel.writeString(userName);
    }
}
