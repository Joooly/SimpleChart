package com.ninghe.jo.mychart.chart.stroke;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;

/**
 * 线条样式
 */
public class BasicStroke {


    public static final BasicStroke DASHED = new BasicStroke(Cap.ROUND, Join.BEVEL, 10, new float[]{10, 10}, 1);// 虚线样式
    public static final BasicStroke DOTTED = new BasicStroke(Cap.ROUND, Join.BEVEL, 5, new float[]{2, 10}, 1);// 点线样式
    public static final BasicStroke SOLID = new BasicStroke(Cap.ROUND, Join.BEVEL, 5, new float[]{0, 0}, 1);// 实线样式

    private Cap mCap;

    private Join mJoin;

    private float mMiter;

    private float[] mIntervals;// 间隔

    private float mPhase;// 路径的阶段效果

    public BasicStroke(Cap cap, Join join, float miter, float[] intervals, float phase) {
        mCap = cap;
        mJoin = join;
        mMiter = miter;
        mIntervals = intervals;
        mPhase = phase;
    }

    public Cap getCap() {
        return mCap;
    }

    public Join getJoin() {
        return mJoin;
    }

    public float getMiter() {
        return mMiter;
    }

    public float[] getIntervals() {
        return mIntervals;
    }

    public float getmPhase() {
        return mPhase;
    }

}
