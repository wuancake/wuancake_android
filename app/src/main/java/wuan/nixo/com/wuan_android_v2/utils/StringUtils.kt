package wuan.nixo.com.wuan_android_v2.utils

import android.content.Context
import android.text.TextUtils

import java.text.DecimalFormat

/**
 * Created by gry
 * 16/9/5 01:20
 * 描述
 */
object StringUtils {
    fun isNotEmpty(str: String?): Boolean {
        if (str == null) return false
        return if (str.length == 0) false else true
    }

    fun isEmpty(str: String?): Boolean {
        if (str == null) return true
        return if (str.length == 0) true else false
    }

    fun getHideName(name: String): String {
        if (isEmpty(name)) return ""
        val first = name.substring(0, 1)
        var xs = ""
        for (i in 0 until name.length - 1) {
            xs += "*"
        }
        return first + xs
    }

    fun getHidePhone(phone: String): String {
        return if (isEmpty(phone)) "" else phone.replace("(\\d{7})\\d{4}".toRegex(), "$1****")
    }

    fun getPhone(pNumber: String): String {
        if (!TextUtils.isEmpty(pNumber) && pNumber.length > 6) {
            val sb = StringBuilder()
            for (i in 0 until pNumber.length) {
                val c = pNumber[i]
                if (i >= 3 && i <= 6) {
                    sb.append('*')
                } else {
                    sb.append(c)
                }
            }
            return sb.toString()
        } else {
            return ""
        }
    }

    /**
     * dp转px
     *
     * @param context
     * @param dipValue
     * @return
     */
    fun dp2px(context: Context, dipValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    /**
     * double 保留两位小数
     *
     * @param dou
     * @return
     */
    fun double2String(dou: Double): String {
        val decimalFormat = DecimalFormat("#0.00")
        return decimalFormat.format(dou)
    }

    /**
     * 千分符
     *
     * @param text
     * @return
     */
    fun fmtMicrometer(text: String): String {
        var df: DecimalFormat? = null
        if (text.indexOf(".") > 0) {
            if (text.length - text.indexOf(".") - 1 == 0) {
                df = DecimalFormat("###,##0.00")
            } else if (text.length - text.indexOf(".") - 1 == 1) {
                df = DecimalFormat("###,##0.00")
            } else {
                df = DecimalFormat("###,##0.00")
            }
        } else {
            df = DecimalFormat("###,##0.00")
        }
        var number = 0.00
        try {
            number = java.lang.Double.parseDouble(text)
        } catch (e: Exception) {
            number = 0.00
        }

        return df.format(number)
    }

}
