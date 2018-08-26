package com.example.administrator.wuanandroid.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdateNameModel;
import com.example.administrator.wuanandroid.Mvp.Presenter.UpdateNamePr;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.Util.BaseActivity;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.SchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @class name: UpdateNameActivity
 * @anthor ：卫士
 * @time :Create on 2018/8/26  7:00
 */
public class UpdateNameActivity extends BaseActivity implements UpdateNameCons.View {
    @BindView(R.id.qg_img)
    ImageView qgImg;
    @BindView(R.id.op_txt)
    EditText opTxt;
    @BindView(R.id.save_name_btn)
    Button saveNameBtn;
    private UpdateNamePr updateNamePr;
    private int userId;
    private String userName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_un_view);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        userId=intent.getIntExtra("userId",0);
        userName=opTxt.getText().toString();
        updateNamePr=new UpdateNamePr(new UpdateNameModel(),this, SchedulerProvider.getInstance());

    }

    @Override
    public void getDateSuccess(List<GetUpateName> getUpateNames) {
        GetUpateName getUpateName=getUpateNames.get(0);
        opTxt.setHint(getUpateName.getUserName());
    }

    @Override
    public void getDataFail(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.qg_img, R.id.save_name_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qg_img:
                finish();
                break;
            case R.id.save_name_btn:
                updateNamePr.GetDate(new UpdateNameBody(userId,userName));
                break;
        }
    }
}
