package com.example.administrator.wuanandroid.Bean.SeeWeekBean

import android.os.Parcel
import android.os.Parcelable

class SeeWeekResponse() :Parcelable{


    /**
     * reports : [{"weekNum":20,"userId":5,"groupId":1,"text":"啊啊啊啊啊啊啊啊<br></br>飒飒撒大所大所大所<br></br>","status":2,"replyTime":"2018-05-21T03:44:09.000+0000"},{"weekNum":21,"userId":5,"groupId":1,"text":"啊啊啊啊啊啊啊啊<br></br>","status":2,"replyTime":"2018-05-21T03:44:09.000+0000"},{"weekNum":22,"userId":5,"groupId":1,"text":"啊啊啊啊啊啊啊啊<br></br>","status":2,"replyTime":"2018-05-21T03:44:09.000+0000"},{"weekNum":23,"userId":5,"groupId":1,"text":"啊啊啊啊啊啊啊啊<br></br>","status":2,"replyTime":"2018-05-21T03:44:09.000+0000"},{"weekNum":24,"userId":5,"groupId":1,"text":"啊啊啊啊啊啊啊啊<br></br>","status":2,"replyTime":"2018-05-21T03:44:09.000+0000"}]
     * count : 100
     */

    var count: Int = 0
    var reports: List<ReportsBean>? = null

    constructor(parcel: Parcel) : this() {
        count = parcel.readInt()
    }

    class ReportsBean {
        /**
         * weekNum : 20
         * userId : 5
         * groupId : 1
         * text : 啊啊啊啊啊啊啊啊<br></br>飒飒撒大所大所大所<br></br>
         * status : 2
         * replyTime : 2018-05-21T03:44:09.000+0000
         */

        var weekNum: Int = 0
        var userId: Int = 0
        var groupId: Int = 0
        var text: String? = null
        var status: Int = 0
        var replyTime: String? = null
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SeeWeekResponse> {
        override fun createFromParcel(parcel: Parcel): SeeWeekResponse {
            return SeeWeekResponse(parcel)
        }

        override fun newArray(size: Int): Array<SeeWeekResponse?> {
            return arrayOfNulls(size)
        }
    }
}
