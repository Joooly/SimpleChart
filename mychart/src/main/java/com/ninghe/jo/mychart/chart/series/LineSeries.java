package com.ninghe.jo.mychart.chart.series;

import com.ninghe.jo.mychart.chart.stroke.BasicStroke;

/**
 * Created by Administrator on 2016/12/19 0019.
 */

public class LineSeries extends DefaultSeries {


    private BasicStroke basicStroke;// 折线样式

    /**
     * 一旦第一条折线设置了样式，陆续的折线都要设置，否则样式都和第一条相同
     */
    public void setBasicStroke(BasicStroke basicStroke) {
        this.basicStroke = basicStroke;
    }

    public BasicStroke getBasicStroke() {
        return basicStroke;
    }

}
