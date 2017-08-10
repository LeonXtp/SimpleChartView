package com.leonxtp.libsimplechart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;

import com.leonxtp.libsimplechart.config.ChartConfigure;
import com.leonxtp.libsimplechart.data.ChartData;
import com.leonxtp.libsimplechart.data.ChartDataAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonxtp on 2017/8/5.
 *
 * @see SimpleChartView 的参数Builder
 */

public class ChartParams {

    private Context mContext;

    //图表y轴边距
    private float marginLeft;
    //y轴顶部边距
    private float marginTop;
    //x轴右边距
    private float marginRight;
    //x轴右边距
    private float marginBottom;

    //x轴代表的意义，比如：日期
    private String xAxisDescription;
    //y轴代表的意义，比如：数量
    private String yAxisDescription;

    //线形图数据最大值
    private float maxDataLine;
    //线形图最多显示数据个数
    private int maxDataCountLine;
    //柱状图数据最大值
    private float maxDataHistogram;
    //柱状图最多显示数据个数
    private int maxDataCountHistogram;

    //横坐标
    private List<String> abscissas = new ArrayList<>();
    //如果横坐标下面还有。。。
    private List<String> secondaryAbscissas = new ArrayList<>();
    //纵坐标
    private List<String> ordinates = new ArrayList<>();

    //横坐标字体大小
    private float textSizeAbscissa;
    //横坐标画笔
    private Paint paintAbscissa;
    //纵坐标字体大小
    private float textSizeOrdinate;
    //纵坐标画笔
    private Paint paintOrdinate;
    //数据字体大小(不同于坐标字体)
    private float textSizeData;
    //数据画笔
    private Paint paintData;
    //所有的文字颜色
    private int colorText;
    //线条宽度
    private float widthLine;

    //线形图数据
    private List<ChartData> datasLine = new ArrayList<>();
    //线形图颜色
    private int colorLine;
    //线条画笔
    private Paint paintLine;

    //柱状图数据
    private List<ChartData> datasHistogram = new ArrayList<>();
    //柱状图颜色
    private int colorHistogram;
    //柱状图默认宽度
    private float widthHistogram;
    //柱状图画笔
    private Paint paintHistogram;

    //横坐标是否从最左边开始
    private boolean isxFromZero;

    private ChartDataAdapter dataAdapter;

    private ChartConfigure configure;

    public List<String> getSecondaryAbscissas() {
        return secondaryAbscissas;
    }

//    public ChartParams setSecondaryAbscissas(List<String> secondaryAbscissas) {
//        this.secondaryAbscissas = secondaryAbscissas;
//        return this;
//    }

    public float getMarginLeft() {
        return marginLeft;
    }

//    public ChartParams setMarginLeft(float marginLeft) {
//        this.marginLeft = marginLeft;
//        return this;
//    }

    public float getMarginTop() {
        return marginTop;
    }

//    public ChartParams setMarginTop(float marginTop) {
//        this.marginTop = marginTop;
//        return this;
//    }

    public float getMarginRight() {
        return marginRight;
    }

//    public ChartParams setMarginRight(float marginRight) {
//        this.marginRight = marginRight;
//        return this;
//    }

    public float getMarginBottom() {
        return marginBottom;
    }

//    public ChartParams setMarginBottom(float marginBottom) {
//        this.marginBottom = marginBottom;
//        return this;
//    }

    public String getxAxisDescription() {
        return xAxisDescription;
    }

//    public ChartParams setxAxisDescription(String xAxisDescription) {
//        this.xAxisDescription = xAxisDescription;
//        return this;
//    }

    public String getyAxisDescription() {
        return yAxisDescription;
    }

//    public ChartParams setyAxisDescription(String yAxisDescription) {
//        this.yAxisDescription = yAxisDescription;
//        return this;
//    }

    public Context getmContext() {
        return mContext;
    }

    public ChartParams with(Context mContext) {
        this.mContext = mContext;
        return this;
    }

    public float getMaxDataLine() {
        return maxDataLine;
    }

//    public ChartParams setMaxDataLine(float maxDataLine) {
//        this.maxDataLine = maxDataLine;
//        return this;
//    }

    public float getMaxDataHistogram() {
        return maxDataHistogram;
    }

//    public ChartParams setMaxDataHistogram(float maxDataHistogram) {
//        this.maxDataHistogram = maxDataHistogram;
//        return this;
//    }

    public List<String> getAbscissas() {
        return abscissas;
    }

//    public ChartParams setAbscissas(List<String> abscissas) {
//        this.abscissas = abscissas;
//        return this;
//    }

    public List<String> getOrdinates() {
        return ordinates;
    }

//    public ChartParams setOrdinates(List<String> ordinates) {
//        this.ordinates = ordinates;
//        return this;
//    }

    public float getTextSizeAbscissa() {
        return textSizeAbscissa;
    }

//    public ChartParams setTextSizeAbscissa(float textSizeAbscissa) {
//        this.textSizeAbscissa = textSizeAbscissa;
//        return this;
//    }

    public float getTextSizeOrdinate() {
        return textSizeOrdinate;
    }

//    public ChartParams setTextSizeOrdinate(float textSizeOrdinate) {
//        this.textSizeOrdinate = textSizeOrdinate;
//        return this;
//    }

    public float getTextSizeData() {
        return textSizeData;
    }

//    public ChartParams setTextSizeData(float textSizeData) {
//        this.textSizeData = textSizeData;
//        return this;
//    }

    public int getColorText() {
        return colorText;
    }

//    public ChartParams setColorText(int colorText) {
//        this.colorText = colorText;
//        return this;
//    }

    public List<ChartData> getDatasLine() {
        return datasLine;
    }

//    public ChartParams setDatasLine(List<ChartData> datasLine) {
//        this.datasLine = datasLine;
//        return this;
//    }

    public int getColorLine() {
        return colorLine;
    }

//    public ChartParams setColorLine(int colorLine) {
//        this.colorLine = colorLine;
//        return this;
//    }

    public List<ChartData> getDatasHistogram() {
        return datasHistogram;
    }

//    public ChartParams setDatasHistogram(List<ChartData> datasHistogram) {
//        this.datasHistogram = datasHistogram;
//        return this;
//    }

    public int getColorHistogram() {
        return colorHistogram;
    }

//    public ChartParams setColorHistogram(int colorHistogram) {
//        this.colorHistogram = colorHistogram;
//        return this;
//    }

    public float getWidthHistogram() {
        return widthHistogram;
    }

//    public ChartParams setWidthHistogram(float widthHistogramDefault) {
//        this.widthHistogram = widthHistogramDefault;
//        return this;
//    }

    public float getWidthLine() {
        return widthLine;
    }

//    public ChartParams setWidthLine(int widthLine) {
//        this.widthLine = widthLine;
//        return this;
//    }

    public boolean isxFromZero() {
        return isxFromZero;
    }

//    public ChartParams setIsxFromZero(boolean isxFromZero) {
//        this.isxFromZero = isxFromZero;
//        return this;
//    }

    public int getMaxDataCountLine() {
        return maxDataCountLine;
    }

//    public ChartParams setMaxDataCountLine(int maxDataCountLine) {
//        this.maxDataCountLine = maxDataCountLine;
//        return this;
//    }

    public int getMaxDataCountHistogram() {
        return maxDataCountHistogram;
    }

//    public ChartParams setMaxDataCountHistogram(int maxDataCountHistogram) {
//        this.maxDataCountHistogram = maxDataCountHistogram;
//        return this;
//    }

    public Paint getPaintAbscissa() {
        return paintAbscissa;
    }

    public Paint getPaintOrdinate() {
        return paintOrdinate;
    }

    public Paint getPaintData() {
        return paintData;
    }

    public Paint getPaintLine() {
        return paintLine;
    }

    public Paint getPaintHistogram() {
        return paintHistogram;
    }

    private Paint getBaseTextPaint(float textSize) {
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(getColorText());
        textPaint.setStrokeWidth(dip2px(mContext, 1));
        textPaint.setTextSize(textSize);
        return textPaint;
    }

    public ChartDataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public ChartParams setDataAdapter(ChartDataAdapter mAdapter) {
        this.dataAdapter = mAdapter;
        return this;
    }

    public ChartConfigure getConfigure() {
        return configure;
    }

    public ChartParams setConfigure(ChartConfigure configure) {
        this.configure = configure;
        return this;
    }

    //最后调用以初始化画笔以及默认参数
    public ChartParams build() {

        this.abscissas.clear();
        for (int i = 0; i < dataAdapter.getAbscissaCount(); i++) {
            abscissas.add(dataAdapter.getAbscissa(i));
        }

        this.secondaryAbscissas.clear();
        for (int i = 0; i < dataAdapter.getAbscissaCount(); i++) {
            this.secondaryAbscissas.add(dataAdapter.getAbscissaSecondary(i));
        }

        this.ordinates.clear();
        for (int i = 0; i < dataAdapter.getOrdinateCount(); i++) {
            this.ordinates.add(dataAdapter.getOrdinate(i));
        }

        this.datasLine.clear();
        for (int i = 0; i < dataAdapter.getDataCountLine(); i++) {
            datasLine.add(dataAdapter.getDataLine(i));
        }

        this.datasHistogram.clear();
        for (int i = 0; i < dataAdapter.getDataCountHistogram(); i++) {
            datasHistogram.add(dataAdapter.getDataHistogram(i));
        }

        this.xAxisDescription = dataAdapter.getXaxisDescription();
        this.yAxisDescription = dataAdapter.getYaxisDescription();
        this.maxDataLine = dataAdapter.getMaxDataLine();//目前还是让线形图和柱状图的最大值相同吧
        this.maxDataHistogram = dataAdapter.getMaxDataHistogram();

        this.maxDataCountLine = dataAdapter.getMaxDataCountLine();
        this.maxDataCountHistogram = dataAdapter.getMaxDataCountHistogram();

        if (this.marginLeft == 0) {
            this.marginLeft = this.configure == null || this.configure.getDataAreaMargins()[0] == 0 ?
                    dip2px(this.mContext, 32) : this.configure.getDataAreaMargins()[0];
        }
        if (this.marginTop == 0) {
            this.marginTop = this.configure == null || this.configure.getDataAreaMargins()[1] == 0 ?
                    dip2px(this.mContext, 24) : this.configure.getDataAreaMargins()[1];
        }
        if (this.marginRight == 0) {
            this.marginRight = this.configure == null || this.configure.getDataAreaMargins()[2] == 0 ?
                    dip2px(this.mContext, 32) : this.configure.getDataAreaMargins()[2];
        }
        if (this.marginBottom == 0) {
            this.marginBottom = this.configure == null || this.configure.getDataAreaMargins()[3] == 0 ?
                    dip2px(this.mContext, 30) : this.configure.getDataAreaMargins()[3];
        }

        if (this.widthLine == 0) {
            this.widthLine = this.configure == null || this.configure.getWidthLine() == 0 ?
                    dip2px(this.mContext, 1) : this.configure.getWidthLine();
        }

        if (this.widthHistogram == 0) {
            this.widthHistogram = this.configure == null || this.configure.getWidthHistogram() == 0 ?
                    dip2px(this.mContext, 4) : this.configure.getWidthHistogram();
        }
        if (textSizeData == 0) {
            this.textSizeData = this.configure == null || this.configure.getTextSizeData() == 0 ?
                    sp2px(this.mContext, 12) : this.configure.getTextSizeData();
        }
        if (this.textSizeAbscissa == 0) {
            this.textSizeAbscissa = this.configure == null || this.configure.getTextSizeAbscissa() == 0 ?
                    sp2px(this.mContext, 12) : this.configure.getTextSizeAbscissa();
        }
        if (this.textSizeOrdinate == 0) {
            this.textSizeOrdinate = this.configure == null || this.configure.getTextSizeOrdinate() == 0 ?
                    sp2px(this.mContext, 12) : this.configure.getTextSizeOrdinate();
        }

        if (this.colorLine == 0) {
            this.colorLine = this.configure == null || this.configure.getColorLine() == 0 ?
                    Color.WHITE : this.configure.getColorLine();
        }

        if (this.colorHistogram == 0) {
            this.colorHistogram = this.configure == null || this.configure.getColorHistogram() == 0 ?
                    Color.WHITE : this.configure.getColorHistogram();
        }

        if (this.colorText == 0) {
            this.colorText = this.configure == null || this.configure.getColorText() == 0 ?
                    Color.WHITE : this.configure.getColorText();
        }

        this.paintAbscissa = getBaseTextPaint(getTextSizeAbscissa());
        this.paintOrdinate = getBaseTextPaint(getTextSizeOrdinate());
        this.paintData = getBaseTextPaint(getTextSizeData());

        this.paintLine = new Paint();
        this.paintLine.setAntiAlias(true);
        this.paintLine.setStyle(Paint.Style.STROKE);
        this.paintLine.setStrokeWidth(dip2px(mContext, (int) getWidthLine()));
        this.paintLine.setStrokeCap(Paint.Cap.ROUND);
        this.paintLine.setColor(getColorLine());

        this.paintHistogram = new Paint();
        this.paintHistogram.setAntiAlias(true);
        this.paintHistogram.setStyle(Paint.Style.FILL);
        this.paintHistogram.setStrokeCap(Paint.Cap.ROUND);
        this.paintHistogram.setColor(getColorHistogram());

        return this;
    }

    private static float density;
    private static float scaledDensity;

    private float dip2px(Context context, int dip) {
        if (density <= 0) {
            setDensity(context);
        }
        return (int) (dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }

    private float sp2px(Context context, int sp) {
        if (scaledDensity <= 0) {
            setDensity(context);
        }
        return (int) (sp * scaledDensity + 0.5f * (sp >= 0 ? 1 : -1));
    }

    private void setDensity(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        density = dm.density;
        scaledDensity = dm.scaledDensity;
    }

}
