package com.example.administrator.wuanandroid.Util.Util.Util.Util.Util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.administrator.wuanandroid.Util.Util.Util.Util.Util.NetUtil.NetWorkManager;

import java.util.HashSet;
import java.util.Set;

public class BaseApplication extends Application{

    private static BaseApplication instance;
    private static Context appContext;
    private Set<Activity> allActivities;


    public static synchronized BaseApplication getInstance(){
        return instance;
    }


    public static Context getApplContext(){
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //网络管理工具单例初始化；
        NetWorkManager.getInstance().init();
        instance = this;
        appContext = instance.getApplicationContext();

    }

    public void addActivity(Activity act){
        if(allActivities == null){
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActiviy(Activity act){
        if(allActivities != null){
            allActivities.remove(act);
        }
    }

    public void exitApp(){
        if(allActivities != null){
            synchronized (allActivities){
                for(Activity activity : allActivities){
                    activity.finish();
                }
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
