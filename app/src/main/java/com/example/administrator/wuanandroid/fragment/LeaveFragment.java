package com.example.administrator.wuanandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.utils.CountDownView;
import com.example.administrator.wuanandroid.utils.L;

/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid.fragment
 * 文件名：   LeaveFragment
 * 创建者:    Nixo
 * 创建时间：  2018/3/19/019-19:52
 * 描述：
 */

public class LeaveFragment extends Fragment {

    L l = new L();
    CountDownView countDownView;
    Button mCancelLeave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave,container,false);
        countDownView = view.findViewById(R.id.leave_csv);
        countDownView.setStopTime(Long.valueOf("604810500"));
        mCancelLeave = view.findViewById(R.id.cancel_Leave);
        mCancelLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.i("取消周报");
            }
        });
        return view;
    }
}
