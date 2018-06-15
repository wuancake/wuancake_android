package com.example.administrator.wuanandroid.mView;
import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.administrator.wuanandroid.R;

public class mLoaddingDialog extends Dialog {

    //这个是模板
    public mLoaddingDialog(Context context, int layout , int style) {
        this(context, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,layout,style, Gravity.CENTER);
    }

    //属性赋值
    public mLoaddingDialog(Context context , int width , int height , int layout, int style,int gravity , int anim){
        super(context,style);
        setContentView(layout);
        //设置属性
        Dialog dialog = new Dialog(context);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.80);
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setWindowAnimations(anim);

    }

    //创建实例
    public mLoaddingDialog(Context context , int width , int height , int layout, int style,int gravity){
        this(context,width,height,layout,style,gravity, R.style.loadding_Style);

    }
}
