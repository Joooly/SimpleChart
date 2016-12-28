package com.ninghe.jo.mychart.chart.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;

import com.ninghe.jo.mychart.chart.renderer.DefaultRenderer;
import com.ninghe.jo.mychart.chart.stroke.BasicStroke;
import com.ninghe.jo.mychart.chart.utils.ChartUtils;

/**
 * Created by Administrator on 2016/12/16 0016.
 */

public abstract class AbstractChart {


    /** 绘制图表，注意调用绘制方法的先后顺序*/
    public abstract void draw(Canvas canvas, int width, int height, Paint paint,Context context);

    /** 绘制图表背景*/
    protected void drawBackground(Canvas canvas, int width, int height, Paint paint, DefaultRenderer defaultRenderer){
        paint.setColor(defaultRenderer.getBackgroundColor());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, width, height, paint);
    }

    /** 绘制网格*/
    protected void drawGrid(Canvas canvas, int width, int height, Paint paint, Context context, DefaultRenderer defaultRenderer){
        paint.setColor(defaultRenderer.getGridColor());
        paint.setStrokeWidth(ChartUtils.convertSize(context,defaultRenderer.getGridLineWidth()));
        BasicStroke basicStroke=defaultRenderer.getGridStroke();
        paint.setStyle(Paint.Style.STROKE);// 绘制路径，一定需要设置画笔的样式为STROKE
        if(basicStroke!=null){// 以下画笔设置只对绘制路径有效，如drawLine，以下设置对其无效
            paint.setStrokeCap(basicStroke.getCap());
            paint.setStrokeJoin(basicStroke.getJoin());
            paint.setStrokeMiter(basicStroke.getMiter());
            PathEffect effect=new DashPathEffect(basicStroke.getIntervals(),basicStroke.getmPhase());
            paint.setPathEffect(effect);
        }

        int yToLeft= ChartUtils.convertSize(context,defaultRenderer.getYToLeft());
        int xToBottom=ChartUtils.convertSize(context,defaultRenderer.getXToBottom());
        int borderWidthY=ChartUtils.convertSize(context,defaultRenderer.getAxisYBorderWidth());
        Path path=new Path();

        if(defaultRenderer.isShowXGrid()){
            int ySpaceNum=defaultRenderer.getAxisYSpaceNum();
            int ySpace=(height-xToBottom-borderWidthY)/ySpaceNum;// Y轴标签的间隔距离
            for(int i=1;i<ySpaceNum+1;i++){
                path.moveTo(yToLeft,height-xToBottom-ySpace*i);
                path.lineTo(width,height-xToBottom-ySpace*i);
                canvas.drawPath(path,paint);// 绘制横向网格
                path.reset();
            }
        }

        if (defaultRenderer.isShowYGrid()){
            int xSpaceNum=defaultRenderer.getAxisXLabel().length;
            int xSpace=(width-yToLeft)/xSpaceNum;// X轴标签的间隔距离
            for(int j=1;j<xSpaceNum+1;j++){
                path.moveTo(yToLeft+j*xSpace,height-xToBottom);
                path.lineTo(yToLeft+j*xSpace,0);
                canvas.drawPath(path,paint);// 绘制纵向网格
                path.reset();
            }
        }
    }

    /** 绘制坐标轴*/
    protected void drawAxis(Canvas canvas, int width, int height, Paint paint, Context context, DefaultRenderer defaultRenderer){
        paint.setStyle(Paint.Style.FILL);// 非绘制路径就将画笔样式设置为实心
        paint.setColor(defaultRenderer.getAxisColor());
        paint.setStrokeWidth(ChartUtils.convertSize(context,defaultRenderer.getAxisThickness()));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(ChartUtils.convertSize(context,defaultRenderer.getAxisLabelTextSize()));

        int yToLeft= ChartUtils.convertSize(context,defaultRenderer.getYToLeft());
        int xToBottom=ChartUtils.convertSize(context,defaultRenderer.getXToBottom());
        int borderWidthY=ChartUtils.convertSize(context,defaultRenderer.getAxisYBorderWidth());

        int spaceLineWidth=5;// 轴间隔标杆长
        int spaceToLabel=2;// 轴间隔标杆到轴标签的距离，一般为0就够了
        Rect rect = new Rect();// 文字的绘制矩形
        float maxHeight=0;// X轴标签文字的最大高
        float maxWidth=0;// Y轴标签文字的最大宽
        boolean isShowY=defaultRenderer.isShowAxisY();

        if(isShowY){
            canvas.drawLine(yToLeft,height-xToBottom,yToLeft,0,paint);// 绘制Y轴
        }
        int ySpaceNum=defaultRenderer.getAxisYSpaceNum();
        int ySpace=(height-xToBottom-borderWidthY)/ySpaceNum;// Y轴标签的间隔距离
        float yMaxValue=defaultRenderer.getAxisYMaxLabel();
        float yMinValue=defaultRenderer.getAxisYMinLabel();
        float ySpaceValue=(yMaxValue-yMinValue)/ySpaceNum;
        for(int i=0;i<=ySpaceNum;i++){
            if(isShowY){
                canvas.drawLine(yToLeft,height-xToBottom-ySpace*i,yToLeft-spaceLineWidth,height-xToBottom-ySpace*i,paint);// 绘制Y轴标杆
            }
            String yLabel=String.valueOf(yMinValue+ySpaceValue*i);
            paint.getTextBounds(yLabel,0,yLabel.length(),rect);
            canvas.drawText(yLabel,yToLeft-spaceLineWidth-spaceToLabel-rect.width(),height-xToBottom-ySpace*i,paint);// 绘制Y轴标签
            maxWidth=Math.max(maxWidth,rect.width());
        }

        canvas.drawLine(yToLeft,height-xToBottom,width,height-xToBottom,paint);// 绘制X轴
        String[] xLabel=defaultRenderer.getAxisXLabel();
        int xSpaceNum=xLabel.length;
        int xSpace=(width-yToLeft)/xSpaceNum;// X轴标签的间隔距离
        for(int i=0;i<xSpaceNum;i++){
            canvas.drawLine(yToLeft+i*xSpace,height-xToBottom,yToLeft+i*xSpace,height-xToBottom+spaceLineWidth,paint);// 绘制X轴标杆
            paint.getTextBounds(xLabel[i],0,xLabel[i].length(),rect);
            canvas.drawText(xLabel[i],yToLeft+i*xSpace,height-xToBottom+spaceLineWidth+spaceToLabel+rect.height(),paint);// 绘制X轴标签
            maxHeight=Math.max(maxHeight,rect.height());
        }

        paint.setTextSize(ChartUtils.convertSize(context,defaultRenderer.getAxisNameTextSize()));

        String axisXName=defaultRenderer.getAxisXName();
        paint.getTextBounds(axisXName,0,axisXName.length(),rect);
        canvas.drawText(axisXName,(width-yToLeft)/2+yToLeft,height-xToBottom+spaceLineWidth+maxHeight+rect.height(),paint);// 绘制X轴名称

        String axisYName=defaultRenderer.getAxisYName();
        paint.getTextBounds(axisYName,0,axisYName.length(),rect);
        drawAngleText(canvas,axisYName,yToLeft-spaceLineWidth-maxWidth-rect.height(),(height-xToBottom)/2,paint,-90);// 绘制Y轴名称

    }

    /** 绘制有旋转角度的文字*/
    protected void drawAngleText(Canvas canvas, String text, float x, float y, Paint paint, float extraAngle){
        canvas.rotate(extraAngle,x,y);
        canvas.drawText(text,x,y,paint);
        canvas.rotate(-extraAngle,x,y);// 注意需要转回来
    }

}
