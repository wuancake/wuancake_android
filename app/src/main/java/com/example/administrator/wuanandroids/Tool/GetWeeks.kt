package com.example.administrator.wuanandroids.Tool

import java.util.Calendar

/**
 * @class name: GetWeeks
 * @anthor ：卫士
 * @time :Create on 2018/9/15  8:00
 */
class GetWeeks {
    fun getweeks(): Int {
        val calendar = Calendar.getInstance()
        //获取当前时间为本月的第几周
        //获取当前时间为本周的第几天
        return calendar.get(Calendar.WEEK_OF_YEAR)
    }
}
