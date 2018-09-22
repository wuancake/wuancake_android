package com.example.administrator.wuanandroids.Mvp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.wuanandroids.Mvp.Contract.RegistCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.PostRegistModel;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.GetRegist;
import com.example.administrator.wuanandroids.Mvp.Model.RegistBean.RegistBody;
import com.example.administrator.wuanandroids.Mvp.Presenter.RegistPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.AndroidWorkround;
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
 * @class name: RegistActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/11  13:26
 */
public class RegistActivity extends BaseActivity implements RegistCons.View {

    @BindView(R.id.user_rg_txt)
    EditText userRgTxt;
    @BindView(R.id.eamil_rg_txt)
    EditText eamilRgTxt;
    @BindView(R.id.QQ_rg_txt)
    EditText QQRgTxt;
    @BindView(R.id.pwd_rg_txt)
    EditText pwdRgTxt;
    @BindView(R.id.okpwd_rg_txt)
    EditText okpwdRgTxt;

    @BindView(R.id.regist_txt)
    TextView registTxt;
    private RegistPr registPr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_regist_view);
        Button registBtn = (Button) findViewById(R.id.regist_btn);
        ButterKnife.bind(this);
        registPr = new RegistPr(new PostRegistModel(), this);
        RxView.clicks(registBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        if (!pwdRgTxt.getText().toString().equals(okpwdRgTxt.getText().toString())) {
                            show_Toast("两次密码不一致，请重新输入");
                        } else {
                            registPr.GetDate(new RegistBody(userRgTxt.getText().toString(),
                                    eamilRgTxt.getText().toString(),
                                    QQRgTxt.getText().toString(),
                                    pwdRgTxt.getText().toString()));
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


    @OnClick({R.id.regist_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regist_txt:
                finish();
                break;
        }
    }

    @Override
    public void getDateSuccess(GetRegist getRegist) {
        if (getRegist.getInfoCode().equals("200")) {
            show_Toast(getRegist.getInfoText());
            finish();
        } else {
            show_Toast(getRegist.getInfoText());
        }
    }

    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("网络错误！");
    }
}
