package com.example.administrator.wuanandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.administrator.wuanandroid.response.LeaveResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveActivity extends AppCompatActivity implements View.OnClickListener{
    TextView leavereturn,weeknumber,leavestatus,
            leaveweekamount1, leaveweekamount2,leaveweekamount3,
            leavesubmit;
    EditText leavereason;
    private int weekamount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
        initView();
    }

    private void initView() {

        leavereturn = findViewById(R.id.btnLeaveReturn);
        weeknumber = findViewById(R.id.tvWeekNumber);
        leavestatus = findViewById(R.id.tvLeaveStatus);
        leaveweekamount1 = findViewById(R.id.btnLeaveWeekAmount1);
        leaveweekamount2 = findViewById(R.id.btnLeaveWeekAmount2);
        leaveweekamount3 = findViewById(R.id.btnLeaveWeekAmount3);
        leavesubmit =findViewById(R.id.btnLeaveSubmit);
        leavereason = findViewById(R.id.etLeaveReason);

        leavereturn.setOnClickListener(this);
        leaveweekamount1.setOnClickListener(this);
        leaveweekamount2.setOnClickListener(this);
        leaveweekamount3.setOnClickListener(this);
        leavesubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLeaveReturn:
                leaveToMain();
            break;
            case R.id.btnLeaveWeekAmount1:
                leaveWeekAmount1();
                break;
            case R.id.btnLeaveWeekAmount2:
                leaveWeekAmount2();
                break;
            case R.id.btnLeaveWeekAmount3:
                leaveWeekAmount3();
                break;
            case R.id.btnLeaveSubmit:
                leaveSubmit();
                break;

        }
    }
    private void leaveWeekAmount1() {
        weekamount = 1;
    }
    private void leaveWeekAmount2() {
        weekamount = 2;
    }
    private void leaveWeekAmount3() {
        weekamount = 3;
    }
    private void leaveSubmit() {
         if(weekamount == 0)
             Toast.makeText(getApplicationContext(), "请选择请假周数", Toast.LENGTH_SHORT).show();
         else if(leavereason.getText().toString().isEmpty())
             Toast.makeText(getApplicationContext(), "请填写请假理由", Toast.LENGTH_SHORT).show();
              else netRequest();

    }

    private void netRequest() {
        RetrofitSingle
                .getRetrofit()
                .create(UserApi.class)
                .leave(UserHelper.currentUser(getApplicationContext()).getUser_id(), weekamount, leavereason.getText().toString())
                .enqueue(new Callback<LeaveResponse>() {
                    @Override
                    public void onResponse(Call<LeaveResponse> call, Response<LeaveResponse> response) {
                        if (response.isSuccessful()) {
                            LeaveResponse leaveResponse = response.body();
                            if (leaveResponse != null) {
                                if (leaveResponse.getInfoCode() == 500) {
                                    Toast.makeText(getApplicationContext(), leaveResponse.getInfoText(), Toast.LENGTH_SHORT).show();
                                } else if (leaveResponse.getInfoCode() == 200) {
                                    Toast.makeText(getApplicationContext(), leaveResponse.getInfoText(), Toast.LENGTH_SHORT).show();

                                   //User user = UserHelper.currentUser(getApplicationContext());
                                   // user.setStatus(leaveResponse.getStatus());
                                    //UserHelper.saveUser(getApplicationContext(), user);
                                    leaveToMain();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LeaveResponse> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "未响应，请检查网络连接", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private void leaveToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putString("name","yzx");
        //intent.putExtra("bundle", bundle);
        startActivity(intent);
        finish();

    }
}

