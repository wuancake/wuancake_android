package com.example.administrator.wuanandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.wuanandroid.MainActivity;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.localAPI.SeeWeek;
import com.example.administrator.wuanandroid.localAPI.SetWeekNewsAPI;
import com.example.administrator.wuanandroid.utils.L;
import com.example.administrator.wuanandroid.utils.SharedUtil;
import com.google.gson.Gson;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.wuanandroid.utils.StaticClass.WUAN_URL;
import com.example.administrator.wuanandroid.Bean.setNewsBean.Request;
import com.example.administrator.wuanandroid.Bean.setNewsBean.Response;
public class WriteActivity extends AppCompatActivity {

    EditText over , help , next,url;
    Button back, setWeekNews , mSave;
    Toolbar toolbar;
    String overEdit , helpEdit,nextEdit , urlEdit;
    SharedUtil util = new SharedUtil();
    L l = new L();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        initView();
        setSupportActionBar(toolbar);
        toolbar.setTitle(" ");



    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        over = findViewById(R.id.week_over);
        help = findViewById(R.id.week_help);
        next = findViewById(R.id.next_week);
        url = findViewById(R.id.url);
        back = findViewById(R.id.write_back);
        setWeekNews = findViewById(R.id.write_set);
        mSave = findViewById(R.id.write_save);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getWeekText();
                if(overEdit.length()<1 || helpEdit.length()<1 || nextEdit.length()<1){
                    Toast.makeText(WriteActivity.this, "必填项不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    saveWeekNews();

                }

            }
        });
        setWeekNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(util.getString(WriteActivity.this,"over"," ") != null
                        &&
                   util.getString(WriteActivity.this,"next"," ") != null
                        &&
                   util.getString(WriteActivity.this,"help"," ") != null
                        ){

                    tijiao(
                            util.getString(WriteActivity.this,"over"," "),
                            util.getString(WriteActivity.this,"help"," "),
                            util.getString(WriteActivity.this,"next"," "),
                            util.getString(WriteActivity.this,"url"," ")
                    );


                }
                getWeekText();
             if(overEdit.length()<1 || helpEdit.length()<1 || nextEdit.length()<1){
                Toast.makeText(WriteActivity.this, "必填项不能为空", Toast.LENGTH_SHORT).show();
            }else{
               tijiao(overEdit,helpEdit,nextEdit,urlEdit);
            }
            }
        });
    }

    public void getWeekText(){
        overEdit = over.getText().toString();
        helpEdit = help.getText().toString();
        nextEdit = help.getText().toString();
        urlEdit = url.getText().toString();
    }

    private void tijiao(String over,String help,String next , String url ){
        final Request request = new Request();
        StringBuffer sb = new StringBuffer();
        //封装实体类
        request.setUserId(Integer.parseInt(util.getString(WriteActivity.this,"UserId","1")));
        request.setGroupId(util.getInt(WriteActivity.this,"Group",0));
        request.setComplete(overEdit+"<br>");
        request.setTrouble(helpEdit+"<br>");
        request.setPlane(nextEdit+"<br>");
        request.setUrl(urlEdit);

        Gson gson = new Gson();
        sb.append(gson.toJson(request));
        l.i(sb.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WUAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SetWeekNewsAPI seeWee = retrofit.create(SetWeekNewsAPI.class);
        //封装请求体
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),sb.toString());
        Call<Response> call = seeWee.SetWeekNews(body);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.body().getInfoCode() == 200){
                    Toast.makeText(WriteActivity.this, response.body().getInfoText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WriteActivity.this,SavedActivity.class);
                    intent.putExtra("XD",2);
                    startActivity(intent);
                }else if(response.body().getInfoCode() == 500){
                    Intent intent = new Intent(WriteActivity.this,SavedActivity.class);
                    intent.putExtra("XD",3);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }

    private void saveWeekNews(){
        if(overEdit.length()<1 || helpEdit.length()<1 || nextEdit.length()<1){
            Toast.makeText(WriteActivity.this, "必填项不能为空", Toast.LENGTH_SHORT).show();
        }else{
        util.putString(WriteActivity.this,"over",overEdit+"<br>");
        util.putString(WriteActivity.this,"help",helpEdit+"<br>");
        util.putString(WriteActivity.this,"next",nextEdit+"<br>");
        util.putString(WriteActivity.this,"url",urlEdit+"<br>");
        Intent intent = new Intent(WriteActivity.this,SavedActivity.class);
        intent.putExtra("XD",1);
        startActivity(intent);
        }
    }


}
