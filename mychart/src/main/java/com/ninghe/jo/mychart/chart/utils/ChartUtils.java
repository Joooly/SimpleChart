package com.ninghe.jo.mychart.chart.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/12/19 0019.
 */

public class ChartUtils {


    /**
     * 根据分辨率获得尺寸，当前适配屏幕720X1280
     */
    public static int convertSize(Context context, int size) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        float ratioWidth = (float) outMetrics.widthPixels / 720;
        float ratioHeight = (float) outMetrics.heightPixels / 1280;
        float ratio = Math.min(ratioWidth, ratioHeight);
        return Math.round(size * ratio);
    }

}
