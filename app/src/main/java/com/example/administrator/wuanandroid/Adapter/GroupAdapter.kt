package com.example.administrator.wuanandroid.Adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.administrator.wuanandroid.Bean.GroupBean.AllGroupBean
import com.example.administrator.wuanandroid.R
import com.example.administrator.wuanandroid.utils.layoutInflater
import kotlinx.android.synthetic.main.item_see.view.*

class GroupAdapter(context: Context, list:ArrayList<AllGroupBean.GroupsBean>, listener : GroupItemClickListener) : RecyclerView.Adapter<GroupAdapter.ViewHolder>() , View.OnClickListener {

    var context = context
    var list = list
    var listener = listener
    var isClick = false


    inner class ViewHolder(v:View) :RecyclerView.ViewHolder(v){
        var text = v.item_week
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v :View = context.layoutInflater.inflate(R.layout.item_see,parent,false)
        v.setOnClickListener(this)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var  bean = list[position]
        holder.text.setText(bean.groupName)
        holder.itemView.tag = bean.id

    }


    override fun onClick(v: View) {

        listener.ClickListner(v.tag as Int)

    }



}