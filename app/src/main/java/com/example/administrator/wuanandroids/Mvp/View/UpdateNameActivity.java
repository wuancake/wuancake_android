package com.example.administrator.wuanandroids.Mvp.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.wuanandroids.Mvp.Contract.UpdateNameCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.GetUpateName;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameBean.UpdateNameBody;
import com.example.administrator.wuanandroids.Mvp.Model.UpdateNameModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.UpdateNamePr;
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
    private int userId=0;
    private String userName=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_un_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        updateNamePr=new UpdateNamePr(new UpdateNameModel(),this);
        opTxt.setHint(PreUtils.INSTANCE.getString(this,"username","---"));
        RxView.clicks(saveNameBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        userName=opTxt.getText().toString();
                        updateNamePr.GetDate(new UpdateNameBody(userId,userName));
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
    public void getDateSuccess(GetUpateName getUpateName) {
        if(getUpateName.getInfoCode().equals("200")){
            PreUtils.INSTANCE.setString(this,"username",getUpateName.getUserName());
            show_Toast(getUpateName.getInfoText());
            Intent intent=new Intent();
            setResult(Activity.RESULT_OK,intent);
            finish();
        }else {
            show_Toast(getUpateName.getInfoText());
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
                setResult(Activity.RESULT_OK,intent);
                finish();
                break;

        }
    }
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            Intent intent=new Intent();
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        return true;
    }
}
