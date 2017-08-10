package com.leonxtp.libsimplechart.data;

/**
 * Created by leonxtp on 2017/8/9.
 * Modified by leonxtp on 2017/8/9
 * <p>
 * 鉴于数据来源各种不确定，不方便"格式化"到参数配置中，
 * 因此在ChartDataAdapter里面统一获取
 */

public abstract class ChartDataAdapter {

    //设置线形图最大可显示的数据个数
    abstract public int getMaxDataCountLine();

    //获取柱状图最大可显示数据个数
    abstract public int getMaxDataCountHistogram();

    //获取横坐标个数
    abstract public int getAbscissaCount();

    //获取指定位置的横坐标
    abstract public String getAbscissa(int position);

    //获取指定位置的二级横坐标
    abstract public String getAbscissaSecondary(int position);

    //获取纵坐标个数
    abstract public int getOrdinateCount();

    //获取指定位置的纵坐标
    abstract public String getOrdinate(int position);

    //获取x轴描述
    abstract public String getXaxisDescription();

    //获取y轴描述
    abstract public String getYaxisDescription();

    //获取线形图最大的数据
    abstract public float getMaxDataLine();

    //获取柱状图最大数据
    abstract public float getMaxDataHistogram();

    //获取线形图数据个数
    abstract public int getDataCountLine();

    //获取柱状图数据个数
    abstract public int getDataCountHistogram();

    ///获取线形图数据
    abstract public ChartData getDataLine(int position);

    ///获取柱状图数据
    abstract public ChartData getDataHistogram(int position);

}
