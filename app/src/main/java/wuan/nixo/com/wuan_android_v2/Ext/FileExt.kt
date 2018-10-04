package wuan.nixo.com.wuan_android_v2.Ext

import android.util.Log

import wuan.nixo.com.wuan_android_v2.Ext.no
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.yes
import java.io.File


private const val TAG = "FileExt"


fun File.ensureDir():Boolean{
    try{
        // 如果这个路径不是文件夹，我们就去看看是不是File
        isDirectory.no{
            //如果是File文件，删掉
            isFile.yes {
                delete()
            }
        }.otherwise {
            //然后我们重新创建文件夹
            return mkdir()
        }
    } catch (e:Exception){
        Log.w(TAG , e.message)
    }
    //如果都不是 返回false
    return false
}