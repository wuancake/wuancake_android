package wuan.nixo.com.wuan_android_v2.utils;

import android.util.Log;

public class Logs {
	private static final String TAG = "carservice";
	private static final boolean ISSHOWINFO = true;// true false url 返回数据
	private static final boolean ISSHOWW = true;// 警告
	private static final boolean ISSHOWD = true;// debug
	private static final boolean ISSHOWV = true;//
	private static final boolean ISSHOWE = true;// 错误

	public static void i(Object data) {
		if (ISSHOWINFO)
			Log.i(TAG, data+"");
	}

	public static void w(Object data) {
		if (ISSHOWW)
			Log.w(TAG, data+"");
	}

	public static void d(Object data) {
		if (ISSHOWD)
			Log.d(TAG, data+"");
	}

	public static void e(Object data) {
		if (ISSHOWE)
			Log.e(TAG, data+"");
	}

	public static void v(Object data) {
		if (ISSHOWV)
			Log.v(TAG, data+"");
	}

}
