package wuan.nixo.com.wuan_android_v2.utils.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wuan.nixo.com.wuan_android_v2.R;


/**
 * Created by gry on 2018/4/9.
 */
public class QuestionsDialog extends BaseDialog {

    private TextView mTitle;
    private TextView mMessage;
    private Button mConfirm;
    private Button mCancel;

    private String title;
    private String message;
    private String confirm;
    private String cancel;

    private int mMessageGravity = Gravity.CENTER;

    private OnClickListener confirmListener;
    private OnClickListener cancelListener;

    public QuestionsDialog(Context context) {
        super(context);
    }

    @Override
    public int getContentResourceId() {
        return R.layout.dialog_questions_p2p;
    }

    public class Base {
        public static final int DIALOG_CLICK_CONFIRM = 1;
        public static final int DIALOG_CLICK_DISMISS = 3;
        public static final int DIALOG_CLICK_CANCEL = 2;
    }

    @Override
    public void initViews() {
        mMessage = (TextView) findViewById(R.id.message);
        mConfirm = (Button) findViewById(R.id.confirm);
        mCancel = (Button) findViewById(R.id.cancel);

        setMessage(message);
        setConfirm(confirm, confirmListener);
        setCancel(cancel, cancelListener);
        findViewById(R.id.window).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCannotClose()) {
                    return;
                }
                onDismiss(Base.DIALOG_CLICK_DISMISS);
            }
        });
        findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isCannotClose()) {
            return;
        }
        onDismiss(Base.DIALOG_CLICK_DISMISS);
    }

    boolean isDismiss = false;

    public void onDismiss(final int clickType) {
        if (isDismiss) {
            return;
        }
        isDismiss = true;
        dismiss();
        if (clickType == Base.DIALOG_CLICK_CONFIRM) {
            if (confirmListener != null) {
                confirmListener.onClick(QuestionsDialog.this, DialogInterface.BUTTON_POSITIVE);
            }
        } else if (clickType == Base.DIALOG_CLICK_CANCEL) {
            if (cancelListener != null) {
                cancelListener.onClick(QuestionsDialog.this, DialogInterface.BUTTON_NEGATIVE);
            }
        } else if (mDismissIsCancel) {
            if (cancelListener != null) {
                cancelListener.onClick(QuestionsDialog.this, DialogInterface.BUTTON_NEGATIVE);
            }
        }
    }

    public void setConfirm(int resId, OnClickListener l) {
        setConfirm(getContext().getString(resId), l);
    }

    public void setCancel(int resId, OnClickListener l) {
        setCancel(getContext().getString(resId), l);
    }

    public void setTitle(int resId) {
        setTitle(getContext().getString(resId));
    }

    public void setMessage(int resId) {
        setMessage(getContext().getString(resId));
    }

    public void setTitle(CharSequence chars) {
        if (TextUtils.isEmpty(chars)) {
            return;
        }
        setTitle(chars.toString());
    }

    public void setMessage(CharSequence chars) {
        if (TextUtils.isEmpty(chars)) {
            return;
        }
        setMessage(chars.toString());
    }

    public void setTitle(String text) {
        title = text;

        if (mTitle == null) {
            return;
        }
        if (TextUtils.isEmpty(title)) {
            mTitle.setVisibility(View.GONE);
            // ct_line.setVisibility(View.GONE);
        } else {
            mTitle.setText(title);
            mTitle.setVisibility(View.VISIBLE);
            // ct_line.setVisibility(View.VISIBLE);
        }
    }

    public void setMessage(String text) {
        message = text;

        if (mMessage == null) {
            return;
        }
        if (TextUtils.isEmpty(message)) {
            mMessage.setVisibility(View.GONE);
        } else {
            mMessage.setGravity(mMessageGravity);
            mMessage.setText(Html.fromHtml(message));
            mMessage.setVisibility(View.VISIBLE);
        }
    }

    public void setConfirm(String text, OnClickListener l) {
        confirm = text;
        confirmListener = l;

        if (mConfirm == null) {
            return;
        }
        if (TextUtils.isEmpty(confirm)) {
            confirmListener = null;
            mConfirm.setOnClickListener(null);
            mConfirm.setVisibility(View.GONE);
        } else {
            mConfirm.setText(confirm);
            mConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDismiss(Base.DIALOG_CLICK_CONFIRM);
                }
            });
            mConfirm.setVisibility(View.VISIBLE);
        }
    }

    public void setCancel(String text, OnClickListener l) {
        cancel = text;
        cancelListener = l;

        if (mCancel == null) {
            return;
        }
        if (TextUtils.isEmpty(cancel)) {
            cancelListener = null;
            mCancel.setOnClickListener(null);
            mCancel.setVisibility(View.GONE);

        } else {
            mCancel.setText(cancel);
            mCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDismiss(Base.DIALOG_CLICK_CANCEL);
                }
            });
            mCancel.setVisibility(View.VISIBLE);
        }
    }

    public void setMessageGravity(int gravity) {
        mMessageGravity = gravity;
    }

    public void setMessageLeftGravity() {
        mMessageGravity = Gravity.LEFT;
    }


}

