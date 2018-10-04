package wuan.nixo.com.wuan_android_v2.View

import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_group.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Adapter.GroupAdapter
import wuan.nixo.com.wuan_android_v2.Common.Api.FINDALLGROUPINFO
import wuan.nixo.com.wuan_android_v2.Common.Api.GROUP
import wuan.nixo.com.wuan_android_v2.Ext.SharedExt
import wuan.nixo.com.wuan_android_v2.Ext.otherwise
import wuan.nixo.com.wuan_android_v2.Ext.pref
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.MainActivity
import wuan.nixo.com.wuan_android_v2.Model.BaseModel
import wuan.nixo.com.wuan_android_v2.Model.GroupModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.ToastUtils
import wuan.nixo.com.wuan_android_v2.utils.dialog.QuestionsDialog
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import wuan.nixo.com.wuan_android_v2.utils.view.BaseActivity
import java.lang.Exception
import kotlin.reflect.KProperty

class GroupActivity : BaseActivity(){
    override val layoutId: Int
        get() = R.layout.activity_group


    override fun initView() {
        findAllGroup()
    }


    fun findAllGroup(){
        var map : Map<String , String> = HashMap()
        MyOkHttpUtils.postJson().json(map).url(FINDALLGROUPINFO).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                Log.i("Nixo","-------分组列表Response--------$response")
                var bean = Gson().fromJson(response,GroupModel::class.java)
                rv_group.layoutManager = StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
                var mGadapter = GroupAdapter(this@GroupActivity,group)
                mGadapter.setDataList(bean.groups)
                rv_group.adapter = mGadapter
                mGadapter.notifyDataSetChanged()
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {
                ToastUtils.newToastCenter(this@GroupActivity,"网络连接失败")
            }

        })
    }
    val group = object : GroupAdapter.chooseGroup {
        override fun onChoose(bean: GroupModel.GroupsBean) {
            var dialog  = QuestionsDialog(this@GroupActivity)
            dialog.setTitle("确认选择分组")
            dialog.setMessage("确认选择${bean.groupName}分租？")
            dialog.show()

            dialog.setCancel("在考虑一下") { _, _->  dialog.dismiss() }
            dialog.setConfirm("确认") { _, _->
                dialog.dismiss()
                    var map = HashMap<String, String>()
                    var userId by SharedExt<String>(this@GroupActivity, "userId", "1")
                    map.put("userId", userId)
                    map.put("groupId", "${bean.id}")
                    MyOkHttpUtils.postJson().json(map).url(GROUP).build().execute(object : StringCallback() {
                        override fun onResponse(response: String?, id: Int) {
                            var bean = Gson().fromJson(response,BaseModel::class.java)
                            ("200" == bean.infoCode).yes{
                                SharedUtil().putInt(this@GroupActivity,"groupId",bean.groupId)
                                ToastUtils.newToastCenter(this@GroupActivity,"选择成功")
                                startActivity(MainActivity::class.java)
                            }.otherwise {
                                ToastUtils.newToastCenter(this@GroupActivity,"${bean.infoText}")
                            }

                        }

                        override fun onError(call: Call?, e: Exception?, id: Int) {
                            dialog.dismiss()
                            ToastUtils.newToastCenter(this@GroupActivity, "网络连接失败")
                        }
                    })


            }
        }


    }

}
