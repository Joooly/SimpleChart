package com.ninghe.jo.mychart.chart.renderer;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class BarRenderer extends DefaultRenderer {


    private int barWidth=10;// 条形图的宽，单位dp

    public void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
    }

    public int getBarWidth() {
        return barWidth;
    }

    /** 由于第一个X轴标签在零点上，绘制条形不美观，故占位处理*/
    @Override
    public void setAxisXLabel(String[] axisXLabel) {
        String[] newXLabel=new String[axisXLabel.length+1];
        newXLabel[0]="";
        for (int i=1;i<newXLabel.length;i++){
            newXLabel[i]=axisXLabel[i-1];
        }
        super.setAxisXLabel(newXLabel);
    }

}
