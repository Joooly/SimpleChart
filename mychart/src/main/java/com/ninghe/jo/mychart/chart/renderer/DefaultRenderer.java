package com.ninghe.jo.mychart.chart.renderer;

import android.graphics.Color;

import com.ninghe.jo.mychart.chart.series.DefaultSeries;
import com.ninghe.jo.mychart.chart.stroke.BasicStroke;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16 0016.
 */

public class DefaultRenderer {


    private int backgroundColor= Color.WHITE;// 图表背景颜色

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    //----------------------------------------------------------------------------------------------

    private int yToLeft=65;// Y轴到画布左边的距离,单位px

    private int xToBottom=60;//  X轴到画布底部的距离，单位px

    private int axisColor=Color.BLACK;// 坐标轴颜色

    private int axisThickness=1;// 坐标轴的粗细，单位px

    private int axisYSpaceNum;// Y轴的间隔数

    private String[] axisXLabel;// X轴标签，从小打到排序，注意要与Y轴值的个数相同

    private float axisYMaxLabel;// Y轴最大标签值，最好大一个单位

    private float axisYMinLabel;// Y轴最小标签值

    private int axisLabelTextSize=15;// 轴标签文字大小，单位px

    private String axisXName;// X轴的名称

    private String axisYName;// Y轴的名称

    private int axisNameTextSize=20;// 轴名称文字大小，单位px

    private int axisYBorderWidth=20;// Y轴最大值到上边界的距离，单位px

    private boolean isShowAxisY=false;// 是否显示Y轴

    public void setYToLeft(int yToLeft) {
        this.yToLeft = yToLeft;
    }

    public void setXToBottom(int xToBottom) {
        this.xToBottom = xToBottom;
    }

    public void setAxisColor(int axisColor) {
        this.axisColor = axisColor;
    }

    public void setAxisThickness(int axisThickness) {
        this.axisThickness = axisThickness;
    }

    public void setAxisYSpaceNum(int axisYSpaceNum) {
        this.axisYSpaceNum = axisYSpaceNum;
    }

    public void setAxisXLabel(String[] axisXLabel) {
        this.axisXLabel = axisXLabel;
    }

    public void setAxisYMaxLabel(float axisYMaxLabel) {
        this.axisYMaxLabel = axisYMaxLabel;
    }

    public void setAxisYMinLabel(float axisYMinLabel) {
        this.axisYMinLabel = axisYMinLabel;
    }

    public void setAxisLabelTextSize(int axisLabelTextSize) {
        this.axisLabelTextSize = axisLabelTextSize;
    }

    public void setAxisXName(String axisXName) {
        this.axisXName = axisXName;
    }

    public void setAxisYName(String axisYName) {
        this.axisYName = axisYName;
    }

    public void setAxisNameTextSize(int axisNameTextSize) {
        this.axisNameTextSize = axisNameTextSize;
    }

    public void setAxisYBorderWidth(int axisYBorderWidth) {
        this.axisYBorderWidth = axisYBorderWidth;
    }

    public void setShowAxisY(boolean showAxisY) {
        isShowAxisY = showAxisY;
    }

    public int getYToLeft() {
        return yToLeft;
    }

    public int getXToBottom() {
        return xToBottom;
    }

    public int getAxisColor() {
        return axisColor;
    }

    public int getAxisThickness() {
        return axisThickness;
    }

    public int getAxisYSpaceNum() {
        return axisYSpaceNum;
    }

    public String[] getAxisXLabel() {
        return axisXLabel;
    }

    public float getAxisYMaxLabel() {
        return axisYMaxLabel;
    }

    public float getAxisYMinLabel() {
        return axisYMinLabel;
    }

    public int getAxisLabelTextSize() {
        return axisLabelTextSize;
    }

    public String getAxisXName() {
        return axisXName;
    }

    public String getAxisYName() {
        return axisYName;
    }

    public int getAxisNameTextSize() {
        return axisNameTextSize;
    }

    public int getAxisYBorderWidth() {
        return axisYBorderWidth;
    }

    public boolean isShowAxisY() {
        return isShowAxisY;
    }

    //----------------------------------------------------------------------------------------------

    private boolean isShowYGrid=false;// 是否显示Y轴方向的网格

    private boolean isShowXGrid=true;// 是否显示X轴方向的网格

    private int gridColor=Color.rgb(240,240,240);// 网格的颜色

    private int gridLineWidth=2;// 网格的线宽，单位px

    private BasicStroke gridStroke;// 网格的线条样式

    public void setGridColor(int gridColor) {
        this.gridColor = gridColor;
    }

    public void setGridLineWidth(int gridLineWidth) {
        this.gridLineWidth = gridLineWidth;
    }

    public void setGridStroke(BasicStroke gridStroke) {
        this.gridStroke = gridStroke;
    }

    public void setShowYGrid(boolean showYGrid) {
        isShowYGrid = showYGrid;
    }

    public void setShowXGrid(boolean showXGrid) {
        isShowXGrid = showXGrid;
    }

    public int getGridColor() {
        return gridColor;
    }

    public int getGridLineWidth() {
        return gridLineWidth;
    }

    public BasicStroke getGridStroke() {
        return gridStroke;
    }

    public boolean isShowYGrid() {
        return isShowYGrid;
    }

    public boolean isShowXGrid() {
        return isShowXGrid;
    }

    //----------------------------------------------------------------------------------------------

    private List<DefaultSeries> seriesList;// 系列的渲染集合

    public void setSeriesList(List<DefaultSeries> seriesList) {
        this.seriesList = seriesList;
    }

    public List<DefaultSeries> getSeriesList() {
        return seriesList;
    }

}
