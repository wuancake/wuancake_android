package wuan.nixo.com.wuan_android_v2.utils;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by acer on 2016/10/12.
 */

public class HideInputUtils {
    /**
     * 设置输入法的显示和隐藏
     *
     * @param v
     * @param event
     * @return
     */
    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }
}
