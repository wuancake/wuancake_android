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

public class ComitedFragment extends Fragment {

    CountDownView countDownView;

    L l  = new L();
    TextView textView;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commited,container,false);
        initView(view);

        return view;
    }

    private void initView(View v) {
        countDownView = v.findViewById(R.id.commited_csv);
        countDownView.setStopTime(Long.valueOf("604810500"));
        textView = v.findViewById(R.id.main_Week);


    }



}
