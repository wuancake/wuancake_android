package wuan.nixo.com.wuan_android_v2.Adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.view.View
import android.widget.TextView
import wuan.nixo.com.wuan_android_v2.Model.GroupModel
import wuan.nixo.com.wuan_android_v2.Model.PaureListModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.view.ListBaseAdapter
import wuan.nixo.com.wuan_android_v2.utils.view.SuperViewHolder

class PaureAdapter(context: Context, itfs : chooseGroup) : ListBaseAdapter<PaureListModel.ReportsBean>
(context) , View.OnClickListener {
    override fun onClick(p0: View?) {
        var bean :PaureListModel.ReportsBean = p0!!.tag as PaureListModel.ReportsBean

    }

    var itf = itfs

    override fun getLayoutId(): Int {
        return R.layout.item_group
    }

    override fun onBindItemHolder(holder: SuperViewHolder?, position: Int) {
        var mTvGroupName = holder?.getView<TextView?>(R.id.tv_itemgroup_name)
        var mGroupCard = holder?.getView<CardView?>(R.id.group_card)
        mGroupCard!!.setOnClickListener { itf.onChoose(mDataList[position]) }
        mTvGroupName!!.text = mDataList.get(position).weekNum.toString()
    }

    public interface chooseGroup{
        fun onChoose(bean :PaureListModel.ReportsBean)
    }

}