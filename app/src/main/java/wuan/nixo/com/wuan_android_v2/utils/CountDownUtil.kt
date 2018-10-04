package wuan.nixo.com.wuan_android_v2.utils

import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import java.util.*

class CountDownUtil(time : Long , start :Long ,var  day :TextView , var  hour :TextView ,var  min
:TextView,var  secon :TextView  ) : CountDownTimer(time , start) {

    var calendar = Calendar.getInstance()

    override fun onFinish() {
        this.start()
    }
    //    millisUntilFinished / (1000 * 60 * 60 * 24) -
    override fun onTick(millisUntilFinished: Long) {
        var millisUntilFinished2  = millisUntilFinished-(((calendar[Calendar.DAY_OF_WEEK]-2 ) * 86400000)
                +((calendar[Calendar.HOUR_OF_DAY]) * 3600000)
                +((calendar[Calendar.MINUTE])*60000)
                +((calendar[Calendar.SECOND])*1000))


        var days =  millisUntilFinished2 / (1000 * 60 * 60 * 24)
        var hours = (millisUntilFinished2 % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
        var minutes = (millisUntilFinished2 % (1000 * 60 * 60)) / (1000 * 60)
        var seconds = ((millisUntilFinished2 % (1000 * 60)) / 1000 )
        day.text = "${days}天"
        hour.text = "${hours}时"
        min.text = "${minutes}分"
        secon.text = "${seconds}秒"
    }

}