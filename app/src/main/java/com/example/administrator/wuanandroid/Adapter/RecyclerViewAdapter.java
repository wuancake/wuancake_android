package com.example.administrator.wuanandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.wuanandroid.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Mvp.Presenter.MyWeeklyPr;
import com.example.administrator.wuanandroid.Mvp.View.MyWeeklyActivity;
import com.example.administrator.wuanandroid.R;

import java.util.List;

/**
 * @class name: RecyclerViewAdapter
 * @anthor ：卫士
 * @time :Create on 2018/8/25  9:25
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Integer> weeks;
    int userId;
    private Context context;
    public static final int BULE= Color.parseColor("#2f94ff");
    public  RecyclerViewAdapter(List<Integer> weeks ,Context context ,int userId){
        this.weeks=weeks;
        this.userId=userId;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mwr_cardview,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        //绑定监听
        //
        holder.mwr_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int position=holder.getAdapterPosition();
              int week=weeks.get(position);
//              holder.mwr_card.setBackgroundColor(BULE);
                Intent intent=new Intent(context,MyWeeklyActivity.class);
                intent.putExtra("week",week);
                intent.putExtra("userId",userId);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int week=weeks.get(i);
        viewHolder.weeks_mwr.setText(week+"");

    }

    @Override
    public int getItemCount() {
        return weeks.size();
    }



    static class ViewHolder extends  RecyclerView.ViewHolder{
        private CardView mwr_card;
        private TextView weeks_mwr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mwr_card=(CardView)itemView.findViewById(R.id.mwr_card);
            weeks_mwr=(TextView)itemView.findViewById(R.id.weeks_mwr);
        }
    }
}
