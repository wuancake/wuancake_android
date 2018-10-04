package wuan.nixo.com.wuan_android_v2.Adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.view.View
import android.widget.BaseAdapter
import android.widget.TextView
import wuan.nixo.com.wuan_android_v2.Model.GroupModel
import wuan.nixo.com.wuan_android_v2.R
import wuan.nixo.com.wuan_android_v2.utils.view.ListBaseAdapter
import wuan.nixo.com.wuan_android_v2.utils.view.SuperViewHolder
import kotlinx.android.synthetic.main.item_group.*

class GroupAdapter(context: Context , itfs : chooseGroup) : ListBaseAdapter<GroupModel.GroupsBean>
(context) , View.OnClickListener {
    override fun onClick(p0: View?) {
        var bean : GroupModel.GroupsBean = p0!!.tag as GroupModel.GroupsBean

    }

    var itf = itfs

    override fun getLayoutId(): Int {
        return R.layout.item_group
    }

    override fun onBindItemHolder(holder: SuperViewHolder?, position: Int) {
       var mTvGroupName = holder?.getView<TextView?>(R.id.tv_itemgroup_name)
       var mGroupCard = holder?.getView<CardView?>(R.id.group_card)
        mTvGroupName?.text = mDataList.get(position).groupName
        mGroupCard!!.setOnClickListener { itf.onChoose(mDataList[position]) }
//        holder!!.getView<View?>(position)?.tag = (mDataList.get(position))
    }

    public interface chooseGroup{
        fun onChoose(bean : GroupModel.GroupsBean)
    }

}