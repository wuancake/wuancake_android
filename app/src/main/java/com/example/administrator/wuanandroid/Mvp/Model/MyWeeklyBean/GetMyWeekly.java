package com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @class name: GetMyWeekly
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:54
 */
public class GetMyWeekly  implements Parcelable{
    public int weekNum;
    public  String complete;
    public String trouble;
    public String plane;
    public String infoText;
    public String url;
    public int infoCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Creator<GetMyWeekly> getCREATOR() {
        return CREATOR;
    }

    protected GetMyWeekly(Parcel in) {
        weekNum = in.readInt();
        complete = in.readString();
        trouble = in.readString();
        plane = in.readString();
        infoText = in.readString();
        infoCode = in.readInt();
        url=in.readString();
    }

    public static final Creator<GetMyWeekly> CREATOR = new Creator<GetMyWeekly>() {
        @Override
        public GetMyWeekly createFromParcel(Parcel in) {
            return new GetMyWeekly(in);
        }

        @Override
        public GetMyWeekly[] newArray(int size) {
            return new GetMyWeekly[size];
        }
    };

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getTrouble() {
        return trouble;
    }

    public void setTrouble(String trouble) {
        this.trouble = trouble;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(weekNum);
        parcel.writeString(complete);
        parcel.writeString(trouble);
        parcel.writeString(plane);
        parcel.writeString(infoText);
        parcel.writeInt(infoCode);
        parcel.writeString(url);
    }
}
