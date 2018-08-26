package com.example.administrator.wuanandroid.Mvp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Adapter.RecyclerViewAdapter;
import com.example.administrator.wuanandroid.Mvp.Contract.MyWeeklyCons;
import com.example.administrator.wuanandroid.Mvp.Model.MyWeeklyModel;
import com.example.administrator.wuanandroid.Mvp.Presenter.MyWeeklyPr;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.Util.BaseFragment;
import com.example.administrator.wuanandroid.Util.NetUtil.Schedulers.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @class name: MwrFragment
 * @anthor ：卫士
 * @time :Create on 2018/8/25  11:36
 */
public class MwrFragment extends BaseFragment {
    List<Integer> weeks = new ArrayList<>();
    View view = null;
    int userId;
    @BindView(R.id.mwr_view)
    RecyclerView mwrView;
    Unbinder unbinder;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=container.getContext();
        view = LayoutInflater.from(context).inflate(setLayoutResourceID(), container, false);
        init();
        unbinder = ButterKnife.bind(this, view);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(container.getContext(),2);
        mwrView.setLayoutManager(gridLayoutManager);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(weeks,context,userId);
        mwrView.setAdapter(adapter);


        return view;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.layout_mwr_fragment;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void init() {
        int week = 143;

        for (int i = 1; i <= 143; i++) {
            weeks.add(i);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
