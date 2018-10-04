package wuan.nixo.com.wuan_android_v2.Ext



/*
    @author Nixo

   这个是密封类，相当于枚举类的扩展类
   在Kotlin1.1之前密封类的子类必须嵌套在密封类中，
   Kotlin1.1之后，没有该限制，这样做的好处是在使用when函数的时候，能表达基本所有选项，尽量可以不用使用else
   out 协变 相当于java的<? extend T> 只可进行返回T类型，属于生产者
 */
sealed class BooleanExt<out T>

object Otherwise: BooleanExt<Nothing>()
class WithData<T>(val data: T): BooleanExt<T>()

inline fun <T> Boolean.yes(block: ()->T) =
        when {
            this -> {
                WithData(block())
            }
            else -> {
                Otherwise
            }
        }

inline fun <T> Boolean.no(block: () -> T) = when {
    this -> Otherwise
    else -> {
        WithData(block())
    }
}

inline fun <T> BooleanExt<T>.otherwise(block: ()->T): T =
        when(this){
            is Otherwise -> block()
            is WithData -> this.data
        }