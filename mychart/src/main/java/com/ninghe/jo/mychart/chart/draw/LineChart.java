package com.ninghe.jo.mychart.chart.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;

import com.ninghe.jo.mychart.chart.renderer.LineRenderer;
import com.ninghe.jo.mychart.chart.series.DefaultSeries;
import com.ninghe.jo.mychart.chart.series.LineSeries;
import com.ninghe.jo.mychart.chart.stroke.BasicStroke;
import com.ninghe.jo.mychart.chart.utils.ChartUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16 0016.
 */

public class LineChart extends AbstractChart {


    private LineRenderer lineRenderer;

    public LineChart(LineRenderer lineRenderer){
        this.lineRenderer=lineRenderer;
    }

    @Override
    public void draw(Canvas canvas, int width, int height, Paint paint,Context context) {
        drawBackground(canvas,width,height,paint,lineRenderer);
        if (lineRenderer.isShowXGrid()||lineRenderer.isShowYGrid()){
            drawGrid(canvas,width,height,paint,context,lineRenderer);
        }
        drawAxis(canvas,width,height,paint,context,lineRenderer);
        drawLineSeries(canvas,width,height,paint,context,lineRenderer);
    }

    /** 绘制折线系列*/
    private void drawLineSeries(Canvas canvas, int width, int height, Paint paint,Context context,LineRenderer lineRenderer){
        paint.setStyle(Paint.Style.FILL);// 非绘制路径就将画笔样式设置为实心
        List<DefaultSeries> seriesList=lineRenderer.getSeriesList();

        int yToLeft= ChartUtils.convertSize(context,lineRenderer.getYToLeft());
        int xToBottom=ChartUtils.convertSize(context,lineRenderer.getXToBottom());
        int borderWidthY=ChartUtils.convertSize(context,lineRenderer.getAxisYBorderWidth());

        int ySpaceNum=lineRenderer.getAxisYSpaceNum();
        int ySpace=(height-xToBottom-borderWidthY)/ySpaceNum;// Y轴标签的间隔距离

        int xSpaceNum=lineRenderer.getAxisXLabel().length;
        int xSpace=(width-yToLeft)/xSpaceNum;// X轴标签的间隔距离

        float maxYLabelValue=lineRenderer.getAxisYMaxLabel();
        float minYLabelValue=lineRenderer.getAxisYMinLabel();

        int listNum=seriesList.size();

        LineSeries series;
        float[] valueY;
        int pointSize=ChartUtils.convertSize(context,lineRenderer.getPointSize());
        for (int i=0;i<listNum;i++){
            series=(LineSeries)seriesList.get(i);
            paint.setColor(series.getSeriesColor());
            valueY=series.getValueY();
            if(xSpaceNum==valueY.length){
                for(int j=0;j<xSpaceNum;j++){
                    canvas.drawCircle(yToLeft+j*xSpace,height-xToBottom-ySpace*(valueY[j]/((maxYLabelValue-minYLabelValue)/ySpaceNum)),pointSize,paint);
                }
            }
        }

        Path path=new Path();
        BasicStroke basicStroke;
        PathEffect effect;
        paint.setStyle(Paint.Style.STROKE);// 绘制路径，一定需要设置画笔的样式为STROKE
        paint.setStrokeWidth(ChartUtils.convertSize(context,lineRenderer.getLineWidth()));
        for(int i=0;i<listNum;i++){
            series=(LineSeries)seriesList.get(i);
            paint.setColor(series.getSeriesColor());
            valueY=series.getValueY();
            if(xSpaceNum==valueY.length){
                basicStroke=series.getBasicStroke();
                if(basicStroke!=null){// 以下画笔设置只对绘制路径有效
                    paint.setStrokeCap(basicStroke.getCap());
                    paint.setStrokeJoin(basicStroke.getJoin());
                    paint.setStrokeMiter(basicStroke.getMiter());
                    effect=new DashPathEffect(basicStroke.getIntervals(),basicStroke.getmPhase());
                    paint.setPathEffect(effect);
                }
                for(int z=0;z<xSpaceNum;z++){
                    if(z>0){
                        path.lineTo(yToLeft+z*xSpace,height-xToBottom-ySpace*(valueY[z]/((maxYLabelValue-minYLabelValue)/ySpaceNum)));
                    }else {
                        path.moveTo(yToLeft+z*xSpace,height-xToBottom-ySpace*(valueY[z]/((maxYLabelValue-minYLabelValue)/ySpaceNum)));
                    }
                }
                canvas.drawPath(path,paint);
                path.reset();
            }
        }
    }

}
