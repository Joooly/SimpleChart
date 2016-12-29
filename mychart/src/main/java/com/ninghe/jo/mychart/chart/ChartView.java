package com.ninghe.jo.mychart.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ninghe.jo.mychart.chart.draw.AbstractChart;

/**
 * Created by Administrator on 2016/12/16 0016.
 */

public class ChartView extends View {

    private Context context;
    private AbstractChart chart;
    private Paint paint;


    public ChartView(Context context) {
        super(context);
        initialize(context);
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    /** 初始化*/
    private void initialize(Context context){
        this.context=context;
        paint=new Paint();
        paint.setAntiAlias(true);// 反锯齿
    }

    /** 设置绘制的图表类型*/
    public void setChart(AbstractChart chart){
        this.chart=chart;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 自定义控件的大小就是画布的大小，自定义控件的位置与画布的位置完全重合，画布的零点就是自定义控件的左上角，故该画布的所有绘制方法的坐标都以当前画布的坐标系为准，不要以屏幕为坐标系
        // 自定义控件的外边距不会影响画布的位置与自定义控件的位置重合，故自定义控件画布的坐标点不代表屏幕的位置点

        int width=canvas.getWidth();
        int height=canvas.getHeight();

        chart.draw(canvas,width,height,paint,context);
    }

}
