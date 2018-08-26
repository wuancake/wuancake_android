package com.example.administrator.wuanandroid.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyModel;
import com.example.administrator.wuanandroid.Mvp.Presenter.MyWeeklyPr;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.Util.BaseActivity;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.SchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @class name: MyWeeklyActivity
 * @anthor ：卫士
 * @time :Create on 2018/8/26  5:57
 */
public class MyWeeklyActivity extends BaseActivity implements MyWeeklyCons.View {

    @BindView(R.id.lwr_img)
    ImageView lwrImg;
    @BindView(R.id.weeks_lwr_txt)
    TextView weeksLwrTxt;
    @BindView(R.id.finish_lwr_txt)
    TextView finishLwrTxt;
    @BindView(R.id.trouble_lwr_txt)
    TextView troubleLwrTxt;
    @BindView(R.id.plan_lwr_txt)
    TextView planLwrTxt;
    @BindView(R.id.url_lwr_txt)
    TextView urlLwrTxt;
   private MyWeeklyPr myWeeklyPr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lwr_view);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        int week=intent.getIntExtra("week",0);
        int userId=intent.getIntExtra("userId",0);
        myWeeklyPr=new MyWeeklyPr(new MyWeeklyModel(),this, SchedulerProvider.getInstance());
        myWeeklyPr.GetDate(new MyWeeklyBody(week,userId));

    }

    @OnClick(R.id.lwr_img)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void getDateSuccess(List<GetMyWeekly> getMyWeeklies) {
            GetMyWeekly getMyWeekly=getMyWeeklies.get(0);
            weeksLwrTxt.setText(getMyWeekly.getWeekNum());
            finishLwrTxt.append(getMyWeekly.getComplete());
            troubleLwrTxt.append(getMyWeekly.getTrouble());
            planLwrTxt.append(getMyWeekly.getPlane());
            urlLwrTxt.append(getMyWeekly.getUrl());
    }

    @Override
    public void getDataFail(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
