package com.example.administrator.wuanandroids.Mvp.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.example.administrator.wuanandroids.Mvp.Contract.LoginCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.GetLogin;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.LoginModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.LoginPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Tool.StatusBar;
import com.example.administrator.wuanandroids.Util.BaseActivity;
import com.jakewharton.rxbinding2.view.RxView;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @class name: LoginActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/11  13:25
 */
public class LoginActivity extends BaseActivity implements LoginCons.View {
    @BindView(R.id.eamil_txt)
    EditText eamilTxt;
    @BindView(R.id.pwd_txt)
    EditText pwdTxt;
    @BindView(R.id.login_regist)
    TextView loginRegist;
    private LoginPr loginPr;
    private ProgressBar bar;
    private ProgressDialog progressDialog;
    private static  final int BLACK= Color.parseColor("#000000");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logins_view);
        ButterKnife.bind(this);
        bar=(ProgressBar)findViewById(R.id.bar);

//        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
//        View parentView = contentFrameLayout.getChildAt(0);
//        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
//            parentView.setFitsSystemWindows(true);
//        }
//
//        StatusBar.compat(this,BLACK);
        View view=new View(this);
//       BarUtils.setStatusBarVisibility(getWindow(),false);
//        BarUtils.setStatusBarAlpha(view,BLACK);
        Button loginBtn=(Button)findViewById(R.id.login_btn);
        loginPr=new LoginPr(new LoginModel(),this);
        if(PreUtils.INSTANCE.getBoolean(this,"first",false)){
            startActivity(new Intent(this,IndexActivity.class));
        }
        RxView.clicks(loginBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {

                        loginPr.GetDate(new LoginBody(eamilTxt.getText().toString(),pwdTxt.getText().toString()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @OnClick({ R.id.login_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_regist:
                startActivity(new Intent(this,RegistActivity.class));
                break;
        }
    }

    @Override
    public void getDateSuccess(GetLogin getLogin) {
    if(getLogin.getInfoCode().equals("200")){
        PreUtils.INSTANCE.setInt(this,"status",getLogin.getStatus());
        PreUtils.INSTANCE.setInt(this,"weeks",getLogin.getCurrWeek());
        PreUtils.INSTANCE.setInt(this,"userId",getLogin.getUserId());
        PreUtils.INSTANCE.setString(this,"username",getLogin.getUserName());
        PreUtils.INSTANCE.setString(this,"email",eamilTxt.getText().toString());
        PreUtils.INSTANCE.setString(this,"groupName",getLogin.getGroupName());
        PreUtils.INSTANCE.setInt(this,"groupId",getLogin.getGroupId());
        PreUtils.INSTANCE.setBoolean(this,"first",true);
        show_Toast(getLogin.getInfoText());
//        show_Toast(getLogin.getStatus()+"");
        if (getLogin.getGroupId()==0) {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, IndexActivity.class);
            startActivity(intent);
        }
    }else{
        show_Toast(getLogin.getInfoText());
    }
    }

    @Override
    public void getDataFail(Throwable throwable) {
    show_Toast("网络错误");
    }
}
