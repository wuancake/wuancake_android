package wuan.nixo.com.wuan_android_v2.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.widget.LinearLayout

import com.google.gson.Gson
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.fragment_paurelist.*
import okhttp3.Call
import wuan.nixo.com.wuan_android_v2.Adapter.GroupAdapter
import wuan.nixo.com.wuan_android_v2.Adapter.PaureAdapter
import wuan.nixo.com.wuan_android_v2.Common.Api.MYWEEKLY
import wuan.nixo.com.wuan_android_v2.Ext.yes
import wuan.nixo.com.wuan_android_v2.Model.GroupModel
import wuan.nixo.com.wuan_android_v2.Model.PaureListModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.View.SeeNewsActivity
import wuan.nixo.com.wuan_android_v2.utils.SharedUtil
import wuan.nixo.com.wuan_android_v2.utils.http.MyOkHttpUtils
import java.lang.Exception

class PaureListFragment :BaseFragment() {
    override val resourceView: Int
        get() = R.layout.fragment_paurelist

    private val chooseGroup = object : PaureAdapter.chooseGroup {
        override fun onChoose(bean: PaureListModel.ReportsBean) {
            var bundel =  Intent(activity!!.baseContext,SeeNewsActivity::class.java)

            bundel.putExtra("status","${bean.status}")
            bundel.putExtra("over",bean.complete)
            bundel.putExtra("wenti",bean.trouble)
            bundel.putExtra("next",bean.plane)
            bundel.putExtra("url",bean.url)
            Log.i("Nixo","----------------------------"+"${bean.status}"+bean.complete+bean
            .trouble+bean.plane+bean.url)
            activity!!.baseContext.startActivity(bundel)

        }
    }



    override fun initView(savedInstanceState: Bundle?) {
        getPaureList()
    }

    fun getPaureList(){
        var map = HashMap<String,Any>()
        map.put("userId",SharedUtil().getInt(activity!!.baseContext,"userId",0))
        map.put("groupId",SharedUtil().getInt(activity!!.baseContext,"groupId",0))
        map.put("weekNum", SharedUtil().getInt(activity!!.baseContext,"week",0))
        map.put("pageNum",1)
        Log.i("NixoRequest",Gson().toJson(map))
        MyOkHttpUtils.postJson().json(map).url(MYWEEKLY).build().execute(object : StringCallback() {
            override fun onResponse(response: String?, id: Int) {
                Log.i("Nixo",response)
                var bean = Gson().fromJson(response,PaureListModel::class.java)
                (bean.reports.size != 0).yes{
                    var adapter = PaureAdapter(activity!!.baseContext,chooseGroup)
                    adapter.setDataList(bean.reports)
                    rv_paure.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
                    rv_paure.adapter = adapter
                }
            }

            override fun onError(call: Call?, e: Exception?, id: Int) {

            }
        })
    }

}