package wuan.nixo.com.wuan_android_v2.utils.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import wuan.nixo.com.wuan_android_v2.R;


/**
 * Created by gry on 2018/4/9.
 */
public class BaseDialog extends Dialog {
    protected Context mContext;
    protected boolean mDismissIsCancel = false;
    protected boolean mCannotClose = false;

    public BaseDialog(Context context) {
        super(context, R.style.NewDialog);
        this.mContext = context;

        if (isCannotClose()) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        } else {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;

        if (isCannotClose()) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        } else {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public int getContentResourceId() {
        return 0;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(getContentResourceId());
            initViews();

            Window dialogWindow = getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            dialogWindow.setGravity(Gravity.CENTER);

            lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度
            lp.height = WindowManager.LayoutParams.MATCH_PARENT; // 高度

            dialogWindow.setAttributes(lp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCannotClose() {
        return mCannotClose;
    }

    public void setCannotClose(boolean mCannotClose) {
        this.mCannotClose = mCannotClose;

        if (mCannotClose) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        } else {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public boolean isDismissIsCancel() {
        return mDismissIsCancel;
    }

    public void setDismissIsCancel(boolean dismissIsCancel) {
        this.mDismissIsCancel = dismissIsCancel;
    }

    public void initViews() {
    }

    @Override
    public void show() {
        try {
            Context context = getContext();
            if (context != null && context instanceof Activity) {
                if (((Activity) context).isFinishing()) {
                    return;
                }
            }
            if (isShowing()) {
                return;
            }
            super.show();
        } catch (Throwable t) {

        }
    }

    @Override
    public void dismiss() {
        try {
            Context context = getContext();
            if (context != null && context instanceof Activity) {
                if (((Activity) context).isFinishing()) {
                    return;
                }
            }
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Throwable t) {

        }
    }


}
