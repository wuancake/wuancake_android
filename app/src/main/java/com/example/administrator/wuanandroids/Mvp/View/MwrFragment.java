package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.wuanandroids.Adapter.RecyclerViewAdapter;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseFragment;

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
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(weeks,context,getActivity());
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
        int week = PreUtils.INSTANCE.getInt(context,"weeks",1);

        for (int i = 0; i <week; i++) {
            weeks.add(week-i);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
