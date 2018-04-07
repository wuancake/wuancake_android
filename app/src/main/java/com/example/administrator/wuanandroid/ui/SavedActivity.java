package com.example.administrator.wuanandroid.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.wuanandroid.MainActivity;
import com.example.administrator.wuanandroid.R;
import com.example.administrator.wuanandroid.fragment.Fragment_Saved;
import com.example.administrator.wuanandroid.fragment.Fragment_SetFail;
import com.example.administrator.wuanandroid.fragment.Fragment_SetSuccessful;

public class SavedActivity extends AppCompatActivity {


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                startActivity(new Intent(SavedActivity.this,MainActivity.class));
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Intent intent = getIntent();
        //1为保存成功
        // 2为提交成功
        // 3为提交失败，
        if(intent.getExtras().getInt("XD") == 1){
            replaceFragent(new Fragment_Saved());
        }else if(intent.getExtras().getInt("XD") == 2){
            replaceFragent(new Fragment_SetSuccessful());
        }else if(intent.getExtras().getInt("XD") == 3){
            replaceFragent(new Fragment_SetFail());
        }



        new timeTread().start();
    }

    private void replaceFragent(android.support.v4.app.Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mFragment,fragment);
        transaction.commit();
    }

    class timeTread extends  Thread{
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = handler.obtainMessage();
            message.what = 1;
            handler.sendMessage(message);
        }
    }
}
