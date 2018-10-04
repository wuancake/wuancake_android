package wuan.nixo.com.wuan_android_v2.Ext



import github.nixo.com.github.Ext.AppContext
import kotlin.reflect.jvm.jvmName

inline fun <reified R, T> R.pref(default: T) = SharedExt(AppContext,"", default, R::class
        .jvmName)