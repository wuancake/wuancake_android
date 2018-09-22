package com.example.administrator.wuanandroids.Mvp.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @class name: IndexOneFragment
 * @anthor ：卫士
 * @time :Create on 2018/9/11  9:35
 */
public class IndexOneFragment extends BaseFragment {

    @BindView(R.id.submit_btn)
    Button submitBtn;
    @BindView(R.id.leave_btn)
    Button leaveBtn;
    Unbinder unbinder;
    Context context;
    @BindView(R.id.weeks_txt)
    TextView weeksTxt;
    @BindView(R.id.days_txt)
    TextView daysTxt;
    @BindView(R.id.hour_txt)
    TextView hourTxt;
    @BindView(R.id.minute_txt)
    TextView minuteTxt;
    @BindView(R.id.s_txt)
    TextView sTxt;
    @BindView(R.id.img)
    ImageView img;
    View view;
    public static final int MSG = 1;
    public static final int RED= Color.parseColor("#ff0000");
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG:
                    if (view != null) {
                        long time = System.currentTimeMillis();
                        Date date = new Date(time);
                        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
                        SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
                        String format3 = format1.format(date);
                        String format4 = format2.format(date);
                        String[] s = format3.split(":");
                        int hour = 0;
                        hour = Integer.parseInt(s[0]);
                        int munite = 0;
                        munite = Integer.parseInt(s[1]);
                        int secend = 0;
                        secend = Integer.parseInt(s[2]);
                        int day = 0;
                        if ("星期一".equals(format4)) {
                            day = 1;
                        } else if ("星期二".equals(format4)) {
                            day = 2;
                        } else if ("星期三".equals(format4)) {
                            day = 3;
                        } else if ("星期四".equals(format4)) {
                            day = 4;
                        } else if ("星期五".equals(format4)) {
                            day = 5;
                        } else if ("星期六".equals(format4)) {
                            day = 6;
                        } else if ("星期日".equals(format4)) {
                            day = 7;
                        }
                        sTxt.setText(59 - secend + "");
                        minuteTxt.setText(59 - munite + "");
                        hourTxt.setText(23 - hour + "");
                        daysTxt.setText(7 - day + "");
                        if((7-day)<3){
                            img.setImageResource(R.mipmap.clock2);
                            daysTxt.setTextColor(RED);
                            hourTxt.setTextColor(RED);
                            minuteTxt.setTextColor(RED);
                            sTxt.setTextColor(RED);
                        }
                    }
                    break;
                default:
                    break;
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        view = LayoutInflater.from(context).inflate(setLayoutResourceID(), container, false);
        unbinder = ButterKnife.bind(this, view);
        int weeks = PreUtils.INSTANCE.getInt(context, "weeks", 0);
        weeksTxt.setText(weeks + "");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg1 = new Message();
                msg1.what = MSG;
                handler.sendMessage(msg1);

                do {

                    try {
                        Thread.sleep(1000);
                        Message msg2 = new Message();
                        msg2.what = MSG;
                        handler.sendMessage(msg2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (true);
            }
        }).start();
        return view;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.indexone_fragment;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void init() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        view = null;
    }

    @OnClick({R.id.submit_btn, R.id.leave_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit_btn:
                startActivity(new Intent(context, SubmitActivity.class));
                break;
            case R.id.leave_btn:

                startActivity(new Intent(context, LeaveActivity.class));
                break;
        }
    }
}
