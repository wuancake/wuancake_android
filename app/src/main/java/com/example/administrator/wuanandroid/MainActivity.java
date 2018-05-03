package com.example.administrator.wuanandroid;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean;
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusBean;
import com.example.administrator.wuanandroid.Bean.StatusBean.StatusRequestBean;
import com.example.administrator.wuanandroid.fragment.ComitedFragment;
import com.example.administrator.wuanandroid.fragment.ComitntFragment;
import com.example.administrator.wuanandroid.fragment.LeaveFragment;
import com.example.administrator.wuanandroid.localAPI.MainStatusLocal;
import com.example.administrator.wuanandroid.localAPI.PostRoute;
import com.example.administrator.wuanandroid.ui.SeeWeekNews;
import com.example.administrator.wuanandroid.utils.L;
import com.example.administrator.wuanandroid.utils.SharedUtil;
import com.example.administrator.wuanandroid.utils.StaticClass;
import com.google.gson.Gson;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar ;
    private DrawerLayout mDrawerLayout;
    private NavigationView NavView ;
    L l = new L();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(toolbar);

        navOnClick(); //侧滑栏点击事件

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.opendrawer);
        }
//         replaceFragent(new ComitntFragment()); //测试
        RequestToStatus();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_main);
        mDrawerLayout  = findViewById(R.id.mDrawerLayout);
        NavView = findViewById(R.id.nav_view);
        //将原来的标题清除
        toolbar.setTitle(" ");
        //Fragment加载选择



    }

    private void intoFragment(String status) {
        //根据返回不同的status来判断是否提交周报加载不同的fragment
        //1为提交，0为没提交，3为已请假
        if(status.equals("1")){
            replaceFragent(new ComitedFragment());
        }else if(status.equals("0")){
            replaceFragent(new ComitntFragment());
        }else if(status.equals("3")){
            replaceFragent(new LeaveFragment());
        }
    }

    public void navOnClick(){
        NavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawer(NavView);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                break;

            case R.id.nav_main:
                mDrawerLayout.closeDrawer(NavView);
                break;
            case R.id.nav_myNews:
                Intent intent = new Intent(MainActivity.this, SeeWeekNews.class);
                startActivity(intent);
                break;
            case R.id.nav_exit:
                onDestroy();
                break;

        }


        return true;
    }


    private void replaceFragent(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_main,fragment);
        transaction.commit();
    }


    private void RequestToStatus(){
        final String s = SharedUtil.getString(MainActivity.this,"UserId","1");
        int userid = Integer.parseInt(s);
        StatusRequestBean bean = new StatusRequestBean();
        bean.setId(userid);
        Gson gson = new Gson();
        final String request = gson.toJson(bean);//请求体


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.WUAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MainStatusLocal local = retrofit.create(MainStatusLocal.class);

        //创建请求体
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),request);
        Call<StatusBean> call = local.status(body);
        call.enqueue(new Callback<StatusBean>() {
            @Override
            public void onResponse(Call<StatusBean> call, Response<StatusBean> response) {
                if(response.body().getInfoCode() == 301){
                    intoFragment(response.body().getStatus().toString());
                    SharedUtil sharedUtil = new SharedUtil();
                    //将周数保存
                    sharedUtil.putString(MainActivity.this,"Week",Integer.toString(response.body().getWeekNum()));
                }if(response.body().getInfoCode() == 500){
                    //响应失败
                    l.w("响应失败");
                    Toast.makeText(MainActivity.this, "服务器响应失败", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<StatusBean> call, Throwable t) {
                Toast.makeText(MainActivity.this, "发生了未知错误", Toast.LENGTH_SHORT).show();
                l.i(t.toString());

            }
        });

    }




}
