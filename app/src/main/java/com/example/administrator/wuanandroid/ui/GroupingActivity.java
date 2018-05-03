package com.example.administrator.wuanandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Bean.GroupBean.GroupingResponse;
import com.example.administrator.wuanandroid.Bean.UserBean.User;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.localAPI.UserApi;

import com.example.administrator.wuanandroid.utils.RetrofitSingle;
import com.example.administrator.wuanandroid.utils.UserHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupingActivity extends AppCompatActivity implements View.OnClickListener {

    TextView webgroup, phpgroup,
            javagroup, uigroup,
            pmgroup, androidgroup,
            submitgroup;
    private int group_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouping);
        //initBundle();
        initView();
    }

   // private void initBundle() {
    //    Bundle bundle=getIntent().getBundleExtra("bundle");
    //    String name=bundle.getString("name");
    //}

    private void initView() {
        webgroup = findViewById(R.id.WebGroup);
        phpgroup = findViewById(R.id.PhpGroup);
        javagroup = findViewById(R.id.JavaGroup);
        uigroup = findViewById(R.id.UiGroup);
        pmgroup = findViewById(R.id.PmGroup);
        androidgroup = findViewById(R.id.AndroidGroup);
        submitgroup = findViewById(R.id.SubmitGroup);
        webgroup.setOnClickListener(this);
        phpgroup.setOnClickListener(this);
        javagroup.setOnClickListener(this);
        uigroup.setOnClickListener(this);
        pmgroup.setOnClickListener(this);
        androidgroup.setOnClickListener(this);
        submitgroup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.WebGroup:
                WebGroup();
                break;
            case R.id.PhpGroup:
                PhpGroup();
                break;
            case R.id.JavaGroup:
                JavaGroup();
                break;
            case R.id.UiGroup:
                UiGroup();
                break;
            case R.id.PmGroup:
                PmGroup();
                break;
            case R.id.AndroidGroup:
                AndroidGroup();
                break;
            case R.id.SubmitGroup:
                SubmitGroup();
                break;
        }
    }

    private void WebGroup() {
        group_id = 1;
    }

    private void PhpGroup() {
        group_id = 2;
    }

    private void JavaGroup() {
        group_id = 3;
    }

    private void UiGroup() {
        group_id = 4;
    }

    private void PmGroup() {
        group_id = 5;
    }

    private void AndroidGroup() {
        group_id = 6;
    }

    private void SubmitGroup() {

        if (group_id == 0) {
            Toast.makeText(getApplicationContext(), "请选择分组", Toast.LENGTH_SHORT).show();

        } else netRequest();
    }

    private void netRequest() {
        RetrofitSingle
                .getRetrofit()
                .create(UserApi.class)
                .grouping(UserHelper.currentUser(getApplicationContext()).getUser_id(), group_id)
                .enqueue(new Callback<GroupingResponse>() {
                    @Override
                    public void onResponse(Call<GroupingResponse> call, Response<GroupingResponse> response) {
                        if (response.isSuccessful()) {
                            GroupingResponse groupingResponse = response.body();
                            if (groupingResponse != null) {
                                if (groupingResponse.getInfoCode() == 500) {
                                    Toast.makeText(getApplicationContext(), groupingResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                } else if (groupingResponse.getInfoCode() == 301) {

                                    User user = UserHelper.currentUser(getApplicationContext());
                                    user.setGroup_id(groupingResponse.getGroup_id());
                                    UserHelper.saveUser(getApplicationContext(), user);
                                    Toast.makeText(getApplicationContext(), groupingResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                    groupingToMain();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GroupingResponse> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "未响应，请检查网络连接", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void groupingToMain(){
        Intent intent = new Intent(this, LeaveActivity.class);
        startActivity(intent);
        finish();
    }

}