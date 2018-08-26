package com.example.administrator.wuanandroid.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroid.Mvp.Model.QuitUnitModel;
import com.example.administrator.wuanandroid.Mvp.Presenter.QuitUnitPr;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.Util.BaseActivity;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.SchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @class name: QuitUnitActivity
 * @anthor ：卫士
 * @time :Create on 2018/8/26  6:55
 */
public class QuitUnitActivity extends BaseActivity implements QuitUnitCons.View {
    @BindView(R.id.qg_img)
    ImageView qgImg;
    @BindView(R.id.qg_btn)
    Button qgBtn;
    private QuitUnitPr quitUnitPr;
    private int userId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_qg_view);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        userId=intent.getIntExtra("userId",0);
        quitUnitPr=new QuitUnitPr(new QuitUnitModel(),this, SchedulerProvider.getInstance());
    }

    @Override
    public void getDateSuccess(List<GetQuitUnit> getQuitUnits) {
        finish();
    }

    @Override
    public void getDataFail(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.qg_img, R.id.qg_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qg_img:
                finish();
                break;
            case R.id.qg_btn:
                quitUnitPr.GetDate(new QuitUnitBody(userId));
                break;
        }
    }
}
