package com.example.administrator.wuanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.wuanandroid.Bean.UserBean.User;

/**
 * Created by ChijinLoujue on 2018/4/24.
 */

public class UserHelper {
    private static User user;

    public static User currentUser(Context context) {
        if (user == null) {
            user = getUser(context);
        }
        return user;
    }

    private static User getUser(Context context) {
        User user = new User();
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        user.setUname(preferences.getString("uname", ""));
        user.setUser_id(preferences.getInt("user_id", 0));
        user.setEmail(preferences.getString("email", ""));
        user.setQq(preferences.getInt("qq", 0));
        user.setPassword(preferences.getString("password", ""));
        user.setGroup_id(preferences.getInt("group_id", 0));
        user.setStatus(preferences.getInt("status",0));
        return user;
    }

    public static void saveUser(Context context, User user) {
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("uname", user.getUname());
        editor.putInt("user_id", user.getUser_id());
        editor.putString("email", user.getEmail());
        editor.putInt("qq", user.getQq());
        editor.putString("password", user.getPassword());
        editor.putInt("group_id", user.getGroup_id());
        editor.putInt("status", user.getStatus());
        editor.apply();
    }
}
