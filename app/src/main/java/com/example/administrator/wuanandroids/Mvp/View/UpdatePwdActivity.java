package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdatePwdCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.GetUpdatePwd;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdBean.UpdatePwdBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdatePwdModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.UpdatePwdPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseActivity;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

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
    private int userId=0;
    private String op_txt=null;
    private String np_txt=null;
    private String okp_txt=null;
    private UpdatePwdPr updatePwdPr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_up_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        updatePwdPr=new UpdatePwdPr(new UpdatePwdModel() ,this);
        RxView.clicks(submitUpBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        op_txt=opTxt.getText().toString();
                        np_txt=npTxt.getText().toString();
                        okp_txt=okpTxt.getText().toString();
                        if (!np_txt.equals(okp_txt)){
                            show_Toast("两次密码不一致，请重新输入！");
                        }else {
                            updatePwdPr.GetDate(new UpdatePwdBody(userId, op_txt, np_txt, okp_txt));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getDateSuccess(GetUpdatePwd getUpdatePwd) {
     if(getUpdatePwd.getInfoCode().equals("200")){
         show_Toast(getUpdatePwd.getInfoText());
         Intent intent=new Intent();
         setResult(5,intent);
         finish();
     }else{
         show_Toast(getUpdatePwd.getInfoText());
     }
    }

    @Override
    public void getDataFail(Throwable throwable) {
       show_Toast("网络错误！");
    }

    @OnClick({R.id.qg_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qg_img:
                Intent intent=new Intent();
                setResult(5,intent);
                finish();
                break;
        }
    }
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            Intent intent=new Intent();
            setResult(5,intent);
            finish();
        }
        return true;
    }
}
