package wuan.nixo.com.wuan_android_v2.Ext




inline fun String.isNull(): kotlin.Boolean {
    if(this.length == 0) {
        println("yes")
        return true
    }else {
        println("no")
        return false
    }
}
