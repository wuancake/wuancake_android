package com.example.administrator.wuanandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.wuanandroid.Adapter.SeeWeekAdapter;
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginRequestBean;
import com.example.administrator.wuanandroid.Bean.LoginBean.LoginResultBean;
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.Request;
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.Response;
import com.example.administrator.wuanandroid.Bean.SeeWeekBean.WeekNews;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.localAPI.PostRoute;
import com.example.administrator.wuanandroid.localAPI.SeeWeek;
import com.example.administrator.wuanandroid.utils.L;
import com.example.administrator.wuanandroid.utils.SharedUtil;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.wuanandroid.utils.StaticClass.WUAN_URL;

public class SeeWeekNews extends AppCompatActivity {

    ArrayList<WeekNews> arrayList ;
    RecyclerView mRecyclerView;
    Button mSeeWeek;
    EditText mInput;
    String week;
    SharedUtil util = new SharedUtil();
    L l = new L();
    SeeWeekAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_week_news);
        initView();



    }

    private void initView() {
        mRecyclerView = findViewById(R.id.seeWeek_RecyclerView);
        mSeeWeek = findViewById(R.id.to_See);
        mInput = findViewById(R.id.Seeweek_EditText);
        week = mInput.getText().toString();
        mSeeWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestToSeeWeekNews(); //查看周报的网络请求方法;
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
    }

    private void RequestToSeeWeekNews() {

        final Request request = new Request();
        StringBuffer route = new StringBuffer();
        request.setUserId(Integer.parseInt(util.getString(SeeWeekNews.this,"UserId","-1")));
        request.setWeekNum(Integer.parseInt(week));
        Gson gson = new Gson();
        route.append(gson.toJson(request));
        l.i(route.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WUAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SeeWeek seeWee = retrofit.create(SeeWeek.class);

        //创建请求体
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route.toString());
        Call<Response> call = seeWee.seeWeek(body);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                arrayList = new ArrayList<>();
                WeekNews weekNews = new WeekNews();
                weekNews.setTitle("本周完成");
                weekNews.setNeirong(response.body().getComplete().toString());
                arrayList.add(weekNews);
                WeekNews weekNews2 = new WeekNews();
                weekNews.setTitle("所遇困难");
                weekNews.setNeirong(response.body().getTrouble());
                arrayList.add(weekNews2);
                WeekNews weekNews3 = new WeekNews();
                weekNews.setTitle("下周完成");
                weekNews.setNeirong(response.body().getPlane());
                arrayList.add(weekNews3);
                WeekNews weekNews4 = new WeekNews();
                weekNews.setTitle("作品链接");
                weekNews.setNeirong(response.body().getUrl());
                arrayList.add(weekNews4);
                adapter = new SeeWeekAdapter(SeeWeekNews.this,arrayList);
                mRecyclerView.setAdapter(adapter);
                }else if(response.body().getInfoText().equals("未提交")){
                    arrayList = new ArrayList<>();
                    WeekNews weekNews = new WeekNews();
                    weekNews.setTitle("本周尚未提交周报");
                    weekNews.setNeirong(response.body().getComplete().toString());
                    adapter = new SeeWeekAdapter(SeeWeekNews.this,arrayList);
                    mRecyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(SeeWeekNews.this, "出现未知错误", Toast.LENGTH_SHORT).show();
                    l.i("500");
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });


    }
}
