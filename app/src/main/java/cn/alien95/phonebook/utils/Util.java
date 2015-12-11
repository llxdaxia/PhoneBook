package cn.alien95.phonebook.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import cn.alien95.phonebook.BuildConfig;

/**
 * Created by llxal on 2015/12/9.
 */
public class Util {

    private static final String TAG = "FUCK";
    private static String DEBUG_LOG_TAG;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void setDebugLog(String tag) {
        DEBUG_LOG_TAG = tag;
    }

    public static void log(String content) {
        if (BuildConfig.DEBUG) {
            Log.i(DEBUG_LOG_TAG, content);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int getScreenWidth(){
        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    public static int getScreenHeight(){
        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.y;
    }
}
