package com.example.administrator.wuanandroid.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.utils.CountDownView;
import com.example.administrator.wuanandroid.utils.L;
import com.example.administrator.wuanandroid.utils.SharedUtil;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   ComitedFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:51
 * 描述：         已提交
 */

public class ComitedFragment extends Fragment implements View.OnClickListener{

    CountDownView countDownView;
    Button commitNews , leave;
    L l  = new L();
    TextView textView;
    SharedPreferences sharedPreferences;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commited,container,false);
        initView(view);
        sharedPreferences = getContext().getSharedPreferences("Shared",Context.MODE_PRIVATE);


        return view;
    }

    private void initView(View v) {
        countDownView = v.findViewById(R.id.commited_csv);
        countDownView.setStopTime(Long.valueOf("604810500"));
        leave = v.findViewById(R.id.main_Leave);
        commitNews =v.findViewById(R.id.main_CommitNews);
        textView = v.findViewById(R.id.main_Week);
        textView.setText(sharedPreferences.getString("Week","XX周"));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_CommitNews:
                l.i("提交周报");
                break;
            case R.id.main_Leave:
                l.i("我要请假");
                break;
        }
    }
}
