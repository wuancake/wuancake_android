package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.wuanandroids.Mvp.Contract.QuitUnitCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.GetQuitUnit;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitBean.QuitUnitBody;
import com.example.administrator.wuanandroids.Mvp.Model.QuitUnitModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.QuitUnitPr;
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
    private int userId=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_qg_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        quitUnitPr=new QuitUnitPr(new QuitUnitModel(),this);
        RxView.clicks(qgBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        quitUnitPr.GetDate(new QuitUnitBody(userId));
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
    public void getDateSuccess(GetQuitUnit getQuitUnits) {
        if(getQuitUnits.getInfoCode().equals("200")){
            PreUtils.INSTANCE.setString(this,"groupName","---");
            show_Toast(getQuitUnits.getInfoText());
//            Intent intent=new Intent();

            PreUtils.INSTANCE.clears(this);
            removeALLActivity();
            startActivity(new Intent(QuitUnitActivity.this,LoginActivity.class));
//            finish();
        }
        else{
            show_Toast(getQuitUnits.getInfoText());
        }


    }

    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("网络错误!");
    }

    @OnClick({R.id.qg_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qg_img:
                Intent intent=new Intent();
                setResult(6,intent);
                finish();
                break;

        }
    }
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            Intent intent=new Intent();
            setResult(6,intent);
            finish();
        }
        return true;
    }

}
