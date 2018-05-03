package com.example.administrator.wuanandroid.ui;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Bean.LoginBean.LoginRequestBean;
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean;
import com.example.administrator.wuanandroid.MainActivity;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.localAPI.PostRoute;
import com.example.administrator.wuanandroid.utils.L;
import com.example.administrator.wuanandroid.utils.SharedUtil;
import com.google.gson.Gson;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.wuanandroid.utils.StaticClass.WUAN_URL;


/**
 * 项目名：   WuanAndroid
 * 包名 ：    com.example.administrator.wuanandroid
 * 文件名：   LoginActivity
 * 创建者:    Nixo
 * 创建时间：  2018/3/16/016-17:54
 * 描述：      登录模块
 */


public class LoginActivity extends AppCompatActivity {


    L l;
    EditText accountInput;
    EditText passwordInput;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        l= new L();
        initView();


    }

    private void initView() {
        accountInput = findViewById(R.id.login_account);
        passwordInput = findViewById(R.id.login_password);
        TextView textView = findViewById(R.id.login_register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        login = findViewById(R.id.login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountStr = accountInput.getText().toString().trim();
                String passwordStr = passwordInput.getText().toString().trim();
                if(!TextUtils.isEmpty(accountStr) & !TextUtils.isEmpty(passwordStr)){
                    String route = RequestToJson(accountStr,passwordStr);
                    RequestToLogin(route);
                }
                if(TextUtils.isEmpty(accountStr) || TextUtils.isEmpty(passwordStr)){
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private String RequestToJson(String accountStr ,String passwordStr) {

            LoginRequestBean login = new LoginRequestBean();
            StringBuffer route = new StringBuffer();
            login.setEmail(accountStr);
            login.setPassword(passwordStr);
            Gson gson = new Gson();
            route.append(gson.toJson(login));
            l.i(route.toString());


        return route.toString();
    }

    private void RequestToLogin(String route){

        //组装请求连接；
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WUAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建接口实体类
        PostRoute postRoute = retrofit.create(PostRoute.class);

        //创建请求体
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);

        Call<LoginResultBean> call = postRoute.login(body);

        //异步发出请求
        call.enqueue(new Callback<LoginResultBean>() {
            @Override
            public void onResponse(Call<LoginResultBean> call, Response<LoginResultBean> response) {
                l.i(response.code()+"");
                l.i(response.body().getUser_id()+"");
                l.i(response.body().getInfoCode());
                if(response.body().getInfoCode().equals("200")){
                    l.i("登陆成功");
                    SharedUtil su = new SharedUtil();
                    su.putString(LoginActivity.this,"UserId" , response.body().getUser_id()+"");
                    su.putInt(LoginActivity.this,"Group",response.body().getGroup_id());
                    l.i(response.body().getUser_id()+""+response.body().getGroup_id());

                    if(response.body().getGroup_id() == 0){
                        startActivity(new Intent(LoginActivity.this,GroupingActivity.class));
                    }else{
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }

                }
                if(response.body().getInfoCode().equals("500")){
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResultBean> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "发生了未知错误", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
