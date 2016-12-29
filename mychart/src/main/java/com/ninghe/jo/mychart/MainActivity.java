package com.ninghe.jo.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ninghe.jo.mychart.chart.ChartView;
import com.ninghe.jo.mychart.chart.draw.LineChart;
import com.ninghe.jo.mychart.chart.renderer.DefaultRenderer;
import com.ninghe.jo.mychart.chart.renderer.LineRenderer;
import com.ninghe.jo.mychart.chart.series.DefaultSeries;
import com.ninghe.jo.mychart.chart.series.LineSeries;
import com.ninghe.jo.mychart.chart.stroke.BasicStroke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ChartView chartView;
    LineRenderer defaultRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chartView= (ChartView) findViewById(R.id.my_chart);

        defaultRenderer=new LineRenderer();
        defaultRenderer.setBackgroundColor(Color.YELLOW);
        defaultRenderer.setYToLeft(65);
        defaultRenderer.setXToBottom(60);
        defaultRenderer.setAxisThickness(1);
        defaultRenderer.setAxisYSpaceNum(5);
        defaultRenderer.setAxisYMaxLabel(5);
        defaultRenderer.setAxisYMinLabel(0);
        defaultRenderer.setAxisXLabel(new String[]{"A","B","C","D","E","F","G","H"});
        defaultRenderer.setAxisXName("时间");
        defaultRenderer.setAxisYName("数值");
        defaultRenderer.setGridStroke(BasicStroke.DASHED);

        List<DefaultSeries> seriesList=new ArrayList<>();
        LineSeries defaultSeries=new LineSeries();
        defaultSeries.setValueY(new float[]{2,1,3,2,0,3,5,1});
        defaultSeries.setBasicStroke(BasicStroke.DASHED);
        seriesList.add(defaultSeries);

        LineSeries defaultSeries2=new LineSeries();
        defaultSeries2.setValueY(new float[]{1,2,1,3,2,1,2,5});
        defaultSeries2.setBasicStroke(BasicStroke.SOLID);
        defaultSeries2.setSeriesColor(Color.GREEN);
        seriesList.add(defaultSeries2);

        defaultRenderer.setSeriesList(seriesList);

        chartView.setChart(new LineChart(defaultRenderer));

    }
}
