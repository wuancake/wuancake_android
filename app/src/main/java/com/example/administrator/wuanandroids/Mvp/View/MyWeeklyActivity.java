package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.wuanandroids.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.GetMyWeekly;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyBean.MyWeeklyBody;
import com.example.administrator.wuanandroids.Mvp.Model.MyWeeklyModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.MyWeeklyPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseActivity;

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
   private  int userId=0;
   private  int groupId=0;
   private  int week=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lwr_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        groupId= PreUtils.INSTANCE.getInt(this,"groupId",0);
        Intent intent=getIntent();
         week= intent.getIntExtra("week",1);
        int weeks= PreUtils.INSTANCE.getInt(this,"weeks",2);
        myWeeklyPr=new MyWeeklyPr(new MyWeeklyModel(),this);
        myWeeklyPr.GetDate(new MyWeeklyBody(userId,groupId,weeks-week+1,1));
    }

    @OnClick(R.id.lwr_img)
    public void onViewClicked() {
        Intent intent=new Intent();
        setResult(8,intent);
        finish();
    }

    @Override
    public void getDateSuccess(GetMyWeekly getMyWeekly) {
        if (getMyWeekly.getInfoCode()==500) {
            show_Toast(getMyWeekly.getInfoText());
        }else{
            if (getMyWeekly.getReports().size()>0) {
                GetMyWeekly.Reports reports = getMyWeekly.getReports().get(0);
                if(reports.getStatus()==2) {
                    weeksLwrTxt.setText("第" + reports.getWeekNum() + "周");
                    finishLwrTxt.append("" + reports.getComplete());
                    troubleLwrTxt.append("" + reports.getTrouble());
                    planLwrTxt.append("" + reports.getPlane());
                    urlLwrTxt.append("" + reports.getUrl());
                }else if(reports.getStatus()==3){
                    show_Toast("已请假！");
                    weeksLwrTxt.setText("第" + reports.getWeekNum() + "周");
                }

            }else {
                weeksLwrTxt.setText("第" + week + "周");
                show_Toast("你这周没提交周报！");
            }
        }
    }

    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("网络错误！");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            Intent intent=new Intent();
            setResult(8,intent);
            finish();
        }
        return true;
    }
}
