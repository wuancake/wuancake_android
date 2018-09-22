package com.example.administrator.wuanandroids.Mvp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @class name: UserFragment
 * @anthor ：卫士
 * @time :Create on 2018/9/11  15:44
 */
public class UserFragment extends BaseFragment {


    Unbinder unbinder;

    Context context;
    @BindView(R.id.name_txt)
    TextView nameTxt;
    @BindView(R.id.name_l)
    LinearLayout nameL;
    @BindView(R.id.email_txt)
    TextView emailTxt;
    @BindView(R.id.group_txt)
    TextView groupTxt;
    @BindView(R.id.pwd_l)
    LinearLayout pwdL;
    @BindView(R.id.exitgroup_l)
    LinearLayout exitgroupL;
    @BindView(R.id.exitbtn_user)
    Button exitbtnUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        View view = LayoutInflater.from(context).inflate(setLayoutResourceID(), container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String userName= PreUtils.INSTANCE.getString(context,"username",null);
        String email= PreUtils.INSTANCE.getString(context,"email",null);
        String groupName= PreUtils.INSTANCE.getString(context,"groupName",null);
        nameTxt.setText(userName);
        emailTxt.setText(email);
        groupTxt.setText(groupName);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.layout_user_view;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void init() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.name_l, R.id.pwd_l, R.id.exitgroup_l, R.id.exitbtn_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.name_l:
                Intent intent=new Intent(context,UpdateNameActivity.class);
                getActivity().startActivityForResult(intent,1);

                break;
            case R.id.pwd_l:
                getActivity().startActivityForResult(new Intent(context,UpdatePwdActivity.class),2);
                break;
            case R.id.exitgroup_l:
                getActivity().startActivityForResult(new Intent(context,QuitUnitActivity.class),3);
                break;
            case R.id.exitbtn_user:
                PreUtils.INSTANCE.clears(context);
                getActivity().finish();
                break;
        }
    }


}
