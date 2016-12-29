package com.ninghe.jo.mychart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.ninghe.jo.mychart.chart.ChartView;
import com.ninghe.jo.mychart.chart.draw.BarChart;
import com.ninghe.jo.mychart.chart.draw.LineChart;
import com.ninghe.jo.mychart.chart.renderer.BarRenderer;
import com.ninghe.jo.mychart.chart.renderer.DefaultRenderer;
import com.ninghe.jo.mychart.chart.series.BarSeries;
import com.ninghe.jo.mychart.chart.series.DefaultSeries;
import com.ninghe.jo.mychart.chart.stroke.BasicStroke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class BarActivity extends Activity {
    ChartView chartView;
    BarRenderer barRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chartView= (ChartView) findViewById(R.id.my_chart);

        barRenderer=new BarRenderer();
//        barRenderer.setBackgroundColor(Color.YELLOW);
        barRenderer.setYToLeft(65);
        barRenderer.setXToBottom(60);
        barRenderer.setAxisThickness(1);
        barRenderer.setAxisYSpaceNum(5);
        barRenderer.setAxisYMaxLabel(5);
        barRenderer.setAxisYMinLabel(0);
        barRenderer.setAxisXLabel(new String[]{"A","B","C","D","E","F","G","H"});
        barRenderer.setAxisXName("时间");
        barRenderer.setAxisYName("数值");
        barRenderer.setGridStroke(BasicStroke.DASHED);

        List<DefaultSeries> seriesList=new ArrayList<>();
        BarSeries barSeries=new BarSeries();
        barSeries.setValueY(new float[]{2,1,3,2.7f,0.5f,3,5,1.5f});
        seriesList.add(barSeries);
        BarSeries barSeries2=new BarSeries();
        barSeries2.setValueY(new float[]{3,2,1,2.7f,1.5f,5,2,2});
        barSeries2.setSeriesColor(Color.RED);
        seriesList.add(barSeries2);
        BarSeries barSeries3=new BarSeries();
        barSeries3.setValueY(new float[]{1,1,2,1.7f,1.2f,2,3,2});
        barSeries3.setSeriesColor(Color.GREEN);
        seriesList.add(barSeries3);
        barRenderer.setSeriesList(seriesList);

        chartView.setChart(new BarChart(barRenderer));

    }
}
