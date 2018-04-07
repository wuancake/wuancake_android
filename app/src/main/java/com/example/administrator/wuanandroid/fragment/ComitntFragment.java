package com.example.administrator.wuanandroid.fragment;

import android.content.Context;
import android.content.Intent;
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

import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.ui.WriteActivity;
import com.example.administrator.wuanandroid.utils.CountDownView;
import com.example.administrator.wuanandroid.utils.L;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   ComitntFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:52
 * 描述：      未提交
 */

public class ComitntFragment extends Fragment {
    TextView mWeek ;
    Button  mCommit , mLeave;
    SharedPreferences sharedPreferences;
    CountDownView countDownView;
    L l  = new L();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commitnt,container,false);
        mWeek = view.findViewById(R.id.commitnt_Week);
        countDownView = view.findViewById(R.id.commitnt_csv);
        sharedPreferences = getContext().getSharedPreferences("Shared", Context.MODE_PRIVATE);
//        textView.setText(sharedPreferences.getString("Week","XX周"));
        countDownView.setStopTime(Long.valueOf("604810500"));


        mCommit = view.findViewById(R.id.commitnt_Commit);
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WriteActivity.class));
                    l.i("跳转到提交周报");
            }
        });
        mLeave = view.findViewById(R.id.commitnt_Leave);
        mLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity()));
                l.i("跳转到请假");
            }
        });
        return view;

    }
}
