package com.ninghe.jo.mychart.chart.renderer;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class LineRenderer extends DefaultRenderer {


    private int pointSize=5;// 坐标点的半径大小，单位px

    private int lineWidth=3;// 折线的宽，单位px

    public void setPointSize(int pointSize) {
        this.pointSize = pointSize;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getPointSize() {
        return pointSize;
    }

    public int getLineWidth() {
        return lineWidth;
    }

}
