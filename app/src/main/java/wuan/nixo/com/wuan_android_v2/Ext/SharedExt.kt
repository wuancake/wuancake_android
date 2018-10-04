package wuan.nixo.com.wuan_android_v2.Ext

import android.content.Context

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedExt<T>(val context: Context, val name: String, val default: T, val prefName: String = "default")
    :ReadWriteProperty<Any?,T> {
    //读写代理我们的SharedExt，第一个泛型参数是代理的类型，这里必须是实体不能使泛型，第二个为参数泛型，可以是实体可以是泛型


    //懒加载  -》 适用于初始化val类型常量，一次初始化，不改变，多次使用。
    //同时lazy也是一种属性委托，将SharedPreferences的初始化所生成的属性委托给sp
    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(findProperName(property))
    }

    private fun findProperName(property: KProperty<*>) = if(name.isEmpty()) property.name else name

    private fun findPreference(key: String): T{
        return when(default){
            is Long -> prefs.getLong(key, default)
            is Int -> prefs.getInt(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            is String -> prefs.getString(key, default)
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(findProperName(property), value)
    }

    private fun putPreference(key: String, value: T){
        with(prefs.edit()){
            when(value){
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("Unsupported type.")
            }
        }.apply()
    }

}