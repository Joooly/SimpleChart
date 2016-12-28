package com.ninghe.jo.mychart.chart.series;

import android.graphics.Color;

/**
 * Created by Administrator on 2016/12/19 0019.
 */

public class DefaultSeries {


    private int seriesColor= Color.BLUE;// 系列的颜色

    private float[] valueY;// Y轴的值，注意要与X轴标签的个数相同

    public void setSeriesColor(int seriesColor) {
        this.seriesColor = seriesColor;
    }

    public void setValueY(float[] valueY) {
        this.valueY = valueY;
    }

    public int getSeriesColor() {
        return seriesColor;
    }

    public float[] getValueY() {
        return valueY;
    }

}
