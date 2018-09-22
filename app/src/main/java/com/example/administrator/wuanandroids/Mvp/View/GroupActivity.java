package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.administrator.wuanandroids.Adapter.GroupViewAdapter;
import com.example.administrator.wuanandroids.Mvp.Contract.AllGroupCons;
import com.example.administrator.wuanandroids.Mvp.Contract.GroupCons;
import com.example.administrator.wuanandroids.Mvp.Model.AllGroupModel;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.AllGroup;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GetGroup;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GroupBody;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.Groupst;
import com.example.administrator.wuanandroids.Mvp.Model.GroupModel;
import com.example.administrator.wuanandroids.Mvp.Model.LoginBean.LoginBody;
import com.example.administrator.wuanandroids.Mvp.Presenter.AllGroupPr;
import com.example.administrator.wuanandroids.Mvp.Presenter.GroupPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseActivity;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @class name: GroupActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/11  13:28
 */
public class GroupActivity extends BaseActivity implements AllGroupCons.View,GroupCons.View {
    @BindView(R.id.group_rview)
    RecyclerView groupRview;
    @BindView(R.id.group_submit)
    Button groupSubmit;
    private int userId = 0;
    private int groupId = 0;
    private AllGroupPr allGroupPr;
    private GroupPr groupPr;
    private GroupViewAdapter adapter;
    private  List<Groupst> groupsts;
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_group_view);
        ButterKnife.bind(this);
        context=this;
        userId = PreUtils.INSTANCE.getInt(this,"userId",0);
        allGroupPr = new AllGroupPr(new AllGroupModel(), this);
        allGroupPr.GetDate();
        groupPr=new GroupPr(new GroupModel(),this);
        RxView.clicks(groupSubmit).throttleLast(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        int position=adapter.getSelectPosition();
                        if(position!=-1){
                            Groupst groupst=groupsts.get(position);
                            PreUtils.INSTANCE.setString(context,"groupName",groupst.getGroupName());
                            groupPr.GetDate(new GroupBody(userId,position+1));
                        }else{
                            show_Toast("请选择一个分组！");
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
    public void getDateSuccess(AllGroup allGroup) {
        if (allGroup.getInfoCode().equals("200")) {
           groupsts=new ArrayList<>();
            groupsts=allGroup.getGroupsList();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            groupRview.setLayoutManager(gridLayoutManager);
            adapter=new GroupViewAdapter(this,groupsts);
            groupRview.setAdapter(adapter);

        } else {
            show_Toast("未知错误！");
        }
    }

    @Override
    public void getDateSuccess(GetGroup getGroup) {
        if(getGroup.getInfoCode().equals("200")) {
            PreUtils.INSTANCE.setInt(this,"groupId",getGroup.getGroupId());
            String groupName=null;
            show_Toast(getGroup.getInfoText());
            finish();
            startActivity(new Intent(this,IndexActivity.class));
        }else{
            show_Toast(getGroup.getInfoText());
        }

    }
    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("未知错误！");
    }


}

