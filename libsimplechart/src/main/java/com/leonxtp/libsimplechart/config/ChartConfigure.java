package com.leonxtp.libsimplechart.config;

/**
 * Created by leonxtp on 2017/8/9.
 * Modified by leonxtp on 2017/8/9
 * <p>
 * 鉴于要配置的参数实在太多，一个个设置很容易漏掉，
 * 因此在configure里面统一配置
 */

public abstract class ChartConfigure {

    //获取图表数据显示区域的边距
    abstract public float[] getDataAreaMargins();

    //获取横坐标文字大小
    abstract public float getTextSizeAbscissa();

    //获取纵坐标文字大小
    abstract public float getTextSizeOrdinate();

    //获取线形图／柱状图上的文字大小
    abstract public float getTextSizeData();

    //获取文字颜色
    abstract public int getColorText();

    //获取线条颜色
    abstract public int getColorLine();

    //获取柱状图颜色
    abstract public int getColorHistogram();

    //获取线形图宽度
    abstract public float getWidthLine();

    //获取柱状图宽度
    abstract public float getWidthHistogram();

    //获取横坐标是否从"0"开始：
    abstract public boolean isxFromZero();

}
