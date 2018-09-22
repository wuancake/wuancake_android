package com.example.administrator.wuanandroids.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.administrator.wuanandroids.Mvp.View.MyWeeklyActivity
import com.example.administrator.wuanandroids.R

/**
 * @class name: RecyclerViewAdapter
 * @anthor ：卫士
 * @time :Create on 2018/8/25  9:25
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    internal lateinit var weeks: List<Int>
    internal var userId: Int = 0
    private var context: Context? = null
    private var activity: Activity? = null

    constructor(weeks: List<Int>, context: Context, activity: Activity) {
        this.weeks = weeks
        this.context = context
        this.activity = activity
    }

    constructor() {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.mwr_cardview, viewGroup, false)
        val holder = ViewHolder(view)
        //绑定监听
        //
        holder.mwr_card.setOnClickListener {
            val position = holder.adapterPosition
            val week = weeks[position]
            val intent = Intent(context, MyWeeklyActivity::class.java)
            intent.putExtra("week", week)
            activity!!.startActivityForResult(intent, 7)
        }
        return holder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val week = weeks[i]
        viewHolder.mwr_card.text = week.toString() + "周"

    }

    override fun getItemCount(): Int {
        return weeks.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mwr_card: Button
        private val weeks_mwr: TextView? = null

        init {
            mwr_card = itemView.findViewById<View>(R.id.mwr_card) as Button
        }
    }

    companion object {
        val BULE = Color.parseColor("#2f94ff")
    }
}
