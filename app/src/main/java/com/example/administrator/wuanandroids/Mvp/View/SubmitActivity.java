package com.example.administrator.wuanandroids.Mvp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.wuanandroids.Mvp.Contract.SubmitCons;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.GetSubmit;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitBean.SubmitBody;
import com.example.administrator.wuanandroids.Mvp.Model.SubmitModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.SubmitPr;
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
 * @class name: SubmitActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/12  12:29
 */
public class SubmitActivity extends BaseActivity implements SubmitCons.View {
    @BindView(R.id.lwr_img)
    ImageView lwrImg;
    @BindView(R.id.submit_btn)
    Button submitBtn;
    @BindView(R.id.save_btn)
    Button saveBtn;
    @BindView(R.id.complete_txt)
    EditText completeTxt;
    @BindView(R.id.troub_txt)
    EditText troubTxt;
    @BindView(R.id.plane_txt)
    EditText planeTxt;
    @BindView(R.id.link_txt)
    EditText linkTxt;
    private SubmitPr submitPr;
    private int userId = 0;
    private int groupId=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_submit_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        groupId= PreUtils.INSTANCE.getInt(this,"groupId",0);
        submitPr = new SubmitPr(new SubmitModel(), this);
        String complete= PreUtils.INSTANCE.getString(this,"complete",null);
        String trouble= PreUtils.INSTANCE.getString(this,"trouble",null);
        String plane= PreUtils.INSTANCE.getString(this,"plane",null);
        String url= PreUtils.INSTANCE.getString(this,"url",null);
        if(complete!=null){
            completeTxt.setText(complete);
        }
        if(trouble!=null){
            troubTxt.setText(trouble);
        }
        if(plane!=null){
            planeTxt.setText(plane);
        }
        if(url!=null){
            linkTxt.setText(url);
        }

        RxView.clicks(submitBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        submitPr.GetDate(new SubmitBody(userId,groupId, completeTxt.getText().toString(), troubTxt.getText().toString(), planeTxt.getText().toString(), linkTxt.getText().toString()));

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
    public void getDateSuccess(GetSubmit getSubmit) {
        if (getSubmit.getInfoCode().equals("200")) {
            PreUtils.INSTANCE.setInt(this,"status",2);
            show_Toast(getSubmit.getInfoText());
            finish();
        } else {
            show_Toast(getSubmit.getInfoText());
        }
    }

    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("网络错误！");
    }

    @OnClick({R.id.lwr_img, R.id.save_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lwr_img:
                finish();
                break;
            case R.id.save_btn:
                PreUtils.INSTANCE.setString(this,"complete",completeTxt.getText().toString());
                PreUtils.INSTANCE.setString(this,"trouble",troubTxt.getText().toString());
                PreUtils.INSTANCE.setString(this,"plane",planeTxt.getText().toString());
                PreUtils.INSTANCE.setString(this,"url",linkTxt.getText().toString());
                show_Toast("保存成功！");
                break;
        }
    }
}
