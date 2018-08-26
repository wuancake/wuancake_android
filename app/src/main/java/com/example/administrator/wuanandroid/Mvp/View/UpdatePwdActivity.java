package com.example.administrator.wuanandroid.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroid.Mvp.Model.UpdatePwdModel;
import com.example.administrator.wuanandroid.Mvp.Presenter.UpdatePwdPr;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.Util.BaseActivity;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.SchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @class name: UpdatePwdActivity
 * @anthor ：卫士
 * @time :Create on 2018/8/26  7:11
 */
public class UpdatePwdActivity extends BaseActivity implements UpdatePwdCons.View {

    @BindView(R.id.qg_img)
    ImageView qgImg;
    @BindView(R.id.op_txt)
    EditText opTxt;
    @BindView(R.id.np_txt)
    EditText npTxt;
    @BindView(R.id.okp_txt)
    EditText okpTxt;
    @BindView(R.id.submit_up_btn)
    Button submitUpBtn;
    private int userId;
    private String op_txt;
    private String np_txt;
    private String okp_txt;
    private UpdatePwdPr updatePwdPr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_up_view);
        ButterKnife.bind(this);
        Intent intent =getIntent();
        userId=intent.getIntExtra("userId",0);
        op_txt=opTxt.getText().toString();
        np_txt=npTxt.getText().toString();
        okp_txt=okpTxt.getText().toString();
        updatePwdPr=new UpdatePwdPr(new UpdatePwdModel() ,this, SchedulerProvider.getInstance());


    }

    @Override
    public void getDateSuccess(List<GetUpdatePwd> getUpdatePwds) {
      Toast.makeText(this,"密码修改成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataFail(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.qg_img, R.id.submit_up_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qg_img:
                finish();
                break;
            case R.id.submit_up_btn:
                updatePwdPr.GetDate(new UpdatePwdBody(userId,op_txt,np_txt,okp_txt));
                break;
        }
    }
}
