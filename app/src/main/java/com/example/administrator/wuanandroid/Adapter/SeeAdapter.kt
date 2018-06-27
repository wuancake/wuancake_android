package com.example.administrator.wuanandroid.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.SeeWeekResponse
import com.example.administrator.wuanandroid.R

import com.example.administrator.wuanandroid.utils.layoutInflater
import kotlinx.android.synthetic.main.item_see.view.*

class SeeAdapter(context:Context , list:ArrayList<SeeWeekResponse.ReportsBean> , listener : MainRecyClickListen) : RecyclerView.Adapter<SeeAdapter.ViewHolder>() , View.OnClickListener {


    var listener = listener
    var context = context
    var list = list
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var week  = itemView.item_week
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = context.layoutInflater.inflate(R.layout.item_see,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int{
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var bean = list[position]
        holder.week.text = "第${bean.weekNum}周"
        holder.itemView.setOnClickListener(this)
        holder.itemView.tag = bean
    }
    override fun onClick(v: View) {
        Log.i("JSY","onClick")
        listener.MainRecyClickListener(v.tag as SeeWeekResponse.ReportsBean)
    }

}
