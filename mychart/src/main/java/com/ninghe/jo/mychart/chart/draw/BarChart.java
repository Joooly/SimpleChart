package com.ninghe.jo.mychart.chart.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.ninghe.jo.mychart.chart.renderer.BarRenderer;
import com.ninghe.jo.mychart.chart.series.BarSeries;
import com.ninghe.jo.mychart.chart.series.DefaultSeries;
import com.ninghe.jo.mychart.chart.utils.ChartUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class BarChart extends AbstractChart {


    private BarRenderer barRenderer;

    public BarChart(BarRenderer barRenderer){
        this.barRenderer=barRenderer;
    }

    @Override
    public void draw(Canvas canvas, int width, int height, Paint paint, Context context) {
        drawBackground(canvas,width,height,paint,barRenderer);
        if (barRenderer.isShowXGrid()||barRenderer.isShowYGrid()){
            drawGrid(canvas,width,height,paint,context,barRenderer);
        }
        drawBarSeries(canvas,width,height,paint,context,barRenderer);
        drawAxis(canvas,width,height,paint,context,barRenderer);
    }

    /** 绘制条形系列*/
    private void drawBarSeries(Canvas canvas,int width, int height, Paint paint,Context context,BarRenderer barRenderer){
        paint.setStyle(Paint.Style.STROKE);// 非绘制路径就将画笔样式设置为实心
        paint.setStrokeCap(Paint.Cap.BUTT);
        List<DefaultSeries> seriesList=barRenderer.getSeriesList();

        int yToLeft= ChartUtils.convertSize(context,barRenderer.getYToLeft());
        int xToBottom=ChartUtils.convertSize(context,barRenderer.getXToBottom());
        int borderWidthY=ChartUtils.convertSize(context,barRenderer.getAxisYBorderWidth());

        int ySpaceNum=barRenderer.getAxisYSpaceNum();
        int ySpace=(height-xToBottom-borderWidthY)/ySpaceNum;// Y轴标签的间隔距离

        int xSpaceNum=barRenderer.getAxisXLabel().length;
        int xSpace=(width-yToLeft)/xSpaceNum;// X轴标签的间隔距离

        float maxYLabelValue=barRenderer.getAxisYMaxLabel();
        float minYLabelValue=barRenderer.getAxisYMinLabel();

        int listNum=seriesList.size();
        int barWidth=ChartUtils.convertSize(context,barRenderer.getBarWidth());
        int barAllWidth=barWidth*listNum;// 所有条形的总宽
        if(barAllWidth>xSpace){
            barAllWidth=xSpace;
            barWidth=xSpace/listNum;
        }
        int markWidth=(barAllWidth-barWidth)/2;// 第一个条形宽的中点到标签点的距离
        paint.setStrokeWidth(barWidth);

        BarSeries series;
        float[] valueY;
        for (int i=0;i<listNum;i++){
            series=(BarSeries) seriesList.get(i);
            paint.setColor(series.getSeriesColor());
            valueY=series.getValueY();
            if(xSpaceNum==valueY.length){
                for(int j=0;j<xSpaceNum;j++){
                    canvas.drawLine(yToLeft+j*xSpace-markWidth+barWidth*i,height-xToBottom,yToLeft+j*xSpace-markWidth+barWidth*i,height-xToBottom-ySpace*(valueY[j]/((maxYLabelValue-minYLabelValue)/ySpaceNum)),paint);
                }
            }
        }
    }

}
