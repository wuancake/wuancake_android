package com.example.administrator.wuanandroids.Mvp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.wuanandroids.Mvp.Contract.LeaveCons;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.GetLeave;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveBean.LeaveBody;
import com.example.administrator.wuanandroids.Mvp.Model.LeaveModel;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Presenter.LeavePr;
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
 * @class name: LeaveActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/12  6:30
 */
public class LeaveActivity extends BaseActivity implements LeaveCons.View {
    @BindView(R.id.lwr_img)
    ImageView lwrImg;
    @BindView(R.id.weeks)
    TextView weeks;
    @BindView(R.id.status_leave)
    TextView statusLeave;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.reson_leave)
    EditText resonLeave;
    @BindView(R.id.leave_btn)
    Button leaveBtn;
    private LeavePr leavePr;
    private ArrayAdapter arrayAdapter;
    private int userId=0;
    private int groupId=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_leave_view);
        ButterKnife.bind(this);
        userId= PreUtils.INSTANCE.getInt(this,"userId",0);
        groupId= PreUtils.INSTANCE.getInt(this,"groupId",0);
        leavePr=new LeavePr(new LeaveModel(),this);
        arrayAdapter=ArrayAdapter.createFromResource(this,R.array.weeks,R.layout.layout_txt);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        RxView.clicks(leaveBtn).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        String s=spinner.getSelectedItem().toString();
                        int num=0;
                        if(s.equals("一周")){
                            num=1;
                        }else if(s.equals("二周")){
                            num=2;
                        }else if(s.equals("三周")){
                            num=3;
                        }
                        leavePr.GetDate(new LeaveBody(userId,groupId,num,resonLeave.getText().toString()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @OnClick({R.id.lwr_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lwr_img:
                finish();
                break;
        }
    }

    @Override
    public void getDateSuccess(GetLeave getLeave) {
    if(getLeave.getInfoCode().equals("200")){
        PreUtils.INSTANCE.setInt(this,"status",3);
        show_Toast(getLeave.getInfoText());
        //重启indexActivity
//        removeActivity(new IndexActivity());

//        new IndexActivity().repalce(new LeaveFragment());
        finish();
//        startActivity(new Intent(this,IndexActivity.class));

    }else {
        show_Toast(getLeave.getInfoText());
    }
    }

    @Override
    public void getDataFail(Throwable throwable) {
    show_Toast("网络错误！");
    }
}
