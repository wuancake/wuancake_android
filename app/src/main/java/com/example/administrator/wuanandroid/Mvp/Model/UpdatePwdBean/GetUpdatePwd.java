package com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @class name: GetUpdatePwd
 * @anthor ：卫士
 * @time :Create on 2018/8/25  10:08
 */
public class GetUpdatePwd  implements Parcelable{

    public String infoText;
    public String infoCode;

    protected GetUpdatePwd(Parcel in) {
        infoText = in.readString();
        infoCode = in.readString();
    }

    public static final Creator<GetUpdatePwd> CREATOR = new Creator<GetUpdatePwd>() {
        @Override
        public GetUpdatePwd createFromParcel(Parcel in) {
            return new GetUpdatePwd(in);
        }

        @Override
        public GetUpdatePwd[] newArray(int size) {
            return new GetUpdatePwd[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(infoText);
        parcel.writeString(infoCode);
    }
}
