package com.ninghe.jo.mychart.chart.series;

/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class BarSeries extends DefaultSeries {


    /**
     * 由于第一个X轴标签在零点上，绘制条形不美观，故占位处理
     */
    @Override
    public void setValueY(float[] valueY) {
        float[] newValueY = new float[valueY.length + 1];
        newValueY[0] = 0;
        for (int i = 1; i < newValueY.length; i++) {
            newValueY[i] = valueY[i - 1];
        }
        super.setValueY(newValueY);
    }

}
