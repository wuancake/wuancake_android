package com.example.administrator.wuanandroid;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView submit, login;
    EditText username, email, qq, password, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        submit = findViewById(R.id.Submit);     //提交按钮
        login = findViewById(R.id.Login);    // 转到登录按钮
        username = findViewById(R.id.RegisterUsername);   //用户名
        email = findViewById(R.id.RegisterEmail);       //邮箱
        qq = findViewById(R.id.RegisterQQ);                    //QQ
        password = findViewById(R.id.RegisterPassword);       //密码
        password2 = findViewById(R.id.RegisterPassword2);      //再次输入密码
        submit.setOnClickListener(this);                 //提交按钮监听
        login.setOnClickListener(this);                  //转到登录按钮监听
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Submit:
                submit();
                break;
            case R.id.Login:
                registerToLogin();
                break;
        }
    }

    private void submit() {

        if (!password.getText().toString().equals(password2.getText().toString())) {     //两次密码输入不一样
            Toast.makeText(getApplicationContext(), "两次密码输入不一致，请重新核对", Toast.LENGTH_SHORT).show();

        } else netRequest();

    }

    private void netRequest() {
        RetrofitSingle
                .getRetrofit()
                .create(UserApi.class)
                .register(username.getText().toString(), email.getText().toString(), qq.getText().toString(), password.getText().toString())
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()) {
                            RegisterResponse registerResponse = response.body();
                            if (registerResponse != null) {
                                if (registerResponse.getInfoCode() == 500) {
                                    Toast.makeText(getApplicationContext(), registerResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                } else if (registerResponse.getInfoCode() == 301) {
                                    Toast.makeText(getApplicationContext(), registerResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                    // Toast.makeText(getApplicationContext(), registerResponse.getInfoText(), Toast.LENGTH_SHORT).show();

                                    User user = new User();
                                    user.setUname(username.getText().toString());
                                    user.setUser_id(registerResponse.getUser_id());
                                    user.setEmail(email.getText().toString());
                                    user.setQq(Integer.parseInt(qq.getText().toString()));
                                    user.setPassword(password.getText().toString());
                                    user.setGroup_id(registerResponse.getGroup_id());
                                    UserHelper.saveUser(getApplicationContext(), user);
                                    //Toast.makeText(getApplicationContext(), registerResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                    registerToLogin();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "未响应，请检查网络连接", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void registerToLogin() {
        Toast.makeText(getApplicationContext(), "按键", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, GroupingActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putString("name","yzx");
        //intent.putExtra("bundle", bundle);
        startActivity(intent);
        finish();

    }

}
