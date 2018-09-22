package com.example.administrator.wuanandroids.Adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton

import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.Groupst
import com.example.administrator.wuanandroids.R

import java.util.ArrayList

/**
 * @class name: GroupViewAdapter
 * @anthor ：卫士
 * @time :Create on 2018/9/15  0:47
 */
class GroupViewAdapter(private val context: Activity, groupsts: List<Groupst>) : RecyclerView.Adapter<GroupViewAdapter.ViewHolder>() {

    internal var groupsts: List<Groupst> = ArrayList()
    var selectPosition = -1
        private set

    init {
        this.groupsts = groupsts
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val group_box: CheckBox

        init {
            group_box = itemView.findViewById<View>(R.id.group_box) as CheckBox
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GroupViewAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_group_box, viewGroup, false)
        val holder = ViewHolder(view)
        holder.group_box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (selectPosition != -1) {
                    //根据id找到上次点击的CheckBox,将它设置为false.
                    val tempCheckBox = context.findViewById<View>(selectPosition) as CheckBox
                    if (tempCheckBox != null) {
                        tempCheckBox.isChecked = false
                    }
                }
                //保存当前选中CheckBox的id值
                selectPosition = buttonView.id

            } else {    //当CheckBox被选中,又被取消时,将tempPosition重新初始化.
                selectPosition = -1
            }
        }
        if (i == selectPosition)
        //比较位置是否一样,一样就设置为选中,否则就设置为未选中.
            holder.group_box.isChecked = true
        else
            holder.group_box.isChecked = false
        return holder
    }

    override fun onBindViewHolder(viewHolder: GroupViewAdapter.ViewHolder, i: Int) {
        val groupst = groupsts[i]
        viewHolder.group_box.text = groupst.groupName
        viewHolder.group_box.id = i

    }

    override fun getItemCount(): Int {
        return groupsts.size
    }
}
