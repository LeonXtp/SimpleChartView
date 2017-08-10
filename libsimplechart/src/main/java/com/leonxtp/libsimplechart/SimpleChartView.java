package com.leonxtp.libsimplechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.leonxtp.libsimplechart.util.DisplayUtil;
import com.leonxtp.libsimplechart.util.ViewUtil;


/**
 * Created by leonxtp on 2017/8/6.
 * 一个简单的易自定义的图表
 * 本图表不自带、不写死任何参数或者设置
 * 一切来自外部的传递
 * 本图表默认横坐标最大值距离x轴右边缘为两个横坐标间距的一半
 * 该图表的y轴最大值和x轴上的数据个数并不限定
 * <p>
 * 缺点是：
 * 这个图表暂不支持左右滑动查看更多数据
 */

public class SimpleChartView extends View {

    //高度可定制化的图表，只有三个属性，所有定制化参数都封装在ChartParams中
    private ChartParams params;
    private float histogramProportion = 1.0f;
    private Path linePath = new Path();

    public SimpleChartView(Context context) {
        super(context);
    }

    public SimpleChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void updateParams(ChartParams chartParams) {
        this.params = chartParams;
        histogramProportion = 0.0f;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (params == null) {
            return;
        }

        histogramProportion += 0.02;

        drawXLine(canvas);
        drawXaxisDesc(canvas);
        drawAbscissa(canvas);

        drawYLine(canvas);
        drawYaxisDesc(canvas);
        drawOrdinates(canvas);

        drawHistogram(canvas);
        drawLineGraph(canvas);

        if (histogramProportion < 1.0f) {
            postInvalidate();
        }
    }

    //X轴
    private void drawXLine(Canvas canvas) {
        canvas.drawLine(params.getMarginLeft(),
                getHeight() - params.getMarginBottom(),
                getWidth() - params.getMarginRight(),
                getHeight() - params.getMarginBottom(),
                params.getPaintAbscissa());
    }

    //横坐标描述
    private void drawXaxisDesc(Canvas canvas) {
        float textHeight = ViewUtil.getTextHeightByPaint(params.getPaintAbscissa());
        //横坐标描述文字与横坐标距离
        float marginleft = DisplayUtil.dip2px(params.getmContext(), 4);
        canvas.drawText(params.getxAxisDescription() == null ? "" : params.getxAxisDescription(),
                getWidth() - params.getMarginRight() + marginleft,
                getHeight() - params.getMarginBottom() + textHeight / 2,
                params.getPaintAbscissa());
    }

    /**
     * 根据横坐标的个数绘制横坐标
     * 默认第一个横坐标距离最左边为每两个横坐标间距的一半
     * 如果设置{@link ChartParams#isxFromZero}为true，则第一个横坐标距离最左边为柱形图的宽度的一半
     */
    private void drawAbscissa(Canvas canvas) {

        if (params.getAbscissas() == null || params.getAbscissas().size() == 0) {
            return;
        }

        int abscissasCount = params.getAbscissas().size();
        float itemMargin, firstDataMargin;
        if (params.isxFromZero()) {
            itemMargin = (getWidth() - params.getMarginLeft() - params.getMarginRight()
                    - params.getWidthHistogram() / 2)
                    / (abscissasCount - 0.5f);
            firstDataMargin = params.getWidthHistogram() / 2;
        } else {
            itemMargin = (getWidth() - params.getMarginLeft() - params.getMarginRight())
                    / (abscissasCount);
            firstDataMargin = itemMargin / 2;
        }

        float textHeight = ViewUtil.getTextHeightByPaint(params.getPaintAbscissa());
        //横坐标文字距离x轴顶部的距离
        float textMarginTop = DisplayUtil.dip2px(params.getmContext(), 2);
        for (int i = 0; i < abscissasCount; i++) {
            float textWidth = ViewUtil.getTextWidth(params.getAbscissas().get(i), params.getPaintAbscissa());
            canvas.drawText(params.getAbscissas().get(i),
                    params.getMarginLeft() + firstDataMargin + itemMargin * i - textWidth / 2,
                    getHeight() - params.getMarginBottom() + textHeight + textMarginTop,
                    params.getPaintAbscissa());

            //如果横坐标下面还有一个次坐标，比如第一行2017/8/8，然后第二行：星期二
            if (params.getSecondaryAbscissas() != null
                    && params.getSecondaryAbscissas().size() > i
                    && params.getSecondaryAbscissas().get(i) != null) {

                float textWidthSecondary = ViewUtil.getTextWidth(params.getAbscissas().get(i), params.getPaintAbscissa());
                canvas.drawText(params.getSecondaryAbscissas().get(i),
                        params.getMarginLeft() + firstDataMargin + itemMargin * i - textWidthSecondary / 2,
                        getHeight() - params.getMarginBottom() + textHeight + textMarginTop + textHeight,
                        params.getPaintAbscissa());
            }
        }

    }

    //Y轴
    private void drawYLine(Canvas canvas) {
        canvas.drawLine(params.getMarginLeft(),
                params.getMarginTop(),
                params.getMarginLeft(),
                getHeight() - params.getMarginBottom(),
                params.getPaintOrdinate());
    }

    //纵坐标表述
    private void drawYaxisDesc(Canvas canvas) {
        float textWidth = ViewUtil.getTextWidth(params.getyAxisDescription(), params.getPaintOrdinate());
        //纵坐标文字描述与y轴距离
        float textMarginBottom = DisplayUtil.dip2px(params.getmContext(), 4);
        canvas.drawText(params.getyAxisDescription(),
                params.getMarginLeft() - textWidth / 2,
                params.getMarginTop() - textMarginBottom,
                params.getPaintOrdinate());
    }

    /**
     * 纵坐标，坐标刻度与文字底部水平对齐
     * 纵坐标最大值距离y轴顶部为每两个纵坐标间距的一半
     */
    private void drawOrdinates(Canvas canvas) {
        if (params.getOrdinates() == null || params.getOrdinates().size() == 0) {
            return;
        }

        int ordicateCount = params.getOrdinates().size();
        float itemMargin = (getHeight() - params.getMarginBottom() - params.getMarginTop())
                / (ordicateCount - 0.5f);

        float textHeight = ViewUtil.getTextHeightByPaint(params.getPaintOrdinate());
        //纵坐标与y轴的距离
        float textMarginRight = DisplayUtil.dip2px(params.getmContext(), 4);
        for (int i = 0; i < ordicateCount; i++) {
            float textWidth = ViewUtil.getTextWidth(params.getOrdinates().get(i), params.getPaintOrdinate());
            canvas.drawText(params.getOrdinates().get(i),
                    params.getMarginLeft() - textWidth - textMarginRight,
                    getHeight() - params.getMarginBottom()  /*+ textHeight / 2*/ - itemMargin * i,
                    params.getPaintOrdinate());
        }
    }

    /**
     * 绘制柱形图
     * 默认第一个柱子x中心距离最左边为每两个横坐标间距的一半
     * 如果设置{@link ChartParams#isxFromZero}为true，则第一个柱子x中心距离最左边为柱形图的宽度的一半，
     * 也就是柱形图紧贴着y轴开始
     * 柱形图最大高度不超过y轴最大刻度
     * y轴最大刻度距离y轴顶部距离为两个刻度间隔的一半
     */
    private void drawHistogram(Canvas canvas) {
        if (params.getDatasHistogram() == null || params.getDatasHistogram().size() == 0) {
            return;
        }
        //最多显示的数据个数
        int maxDataCount = params.getMaxDataCountHistogram();
        float itemMarginX, firstDataMargin;
        if (params.isxFromZero()) {
            itemMarginX = (getWidth() - params.getMarginLeft() - params.getMarginRight()
                    - params.getWidthHistogram() / 2)
                    / (maxDataCount - 0.5f);
            firstDataMargin = params.getWidthHistogram() / 2;
        } else {
            itemMarginX = (getWidth() - params.getMarginLeft() - params.getMarginRight())
                    / maxDataCount;
            firstDataMargin = itemMarginX / 2;
        }

        //纵坐标的间隔，用于得到y轴最大刻度距离y轴顶部的距离
        float itemMarginOnY = (getHeight() - params.getMarginBottom() - params.getMarginTop())
                / (params.getOrdinates().size() - 0.5f);

        int ordinates = params.getOrdinates().size();
        float dataAreaHeight = (getHeight() - params.getMarginTop() - params.getMarginBottom()) * ((ordinates - 1f)
                / (ordinates - 0.5f));
        int dataLength = params.getDatasHistogram().size();
        //当提供的数据量超过所能显示的最大数据个数时，只显示最多支持的个数
        dataLength = dataLength < maxDataCount ? dataLength : maxDataCount;

        for (int i = 0; i < dataLength; i++) {
            float startX;
            float stopX;
            if (i == 0 && params.isxFromZero()) {//如果靠边开始，则第一个柱形只能显示一半的宽度
                startX = params.getMarginLeft();
                stopX = startX + params.getWidthHistogram() / 2;
            } else {
                startX = params.getMarginLeft() + firstDataMargin + itemMarginX * i
                        - params.getWidthHistogram() / 2;
                stopX = startX + params.getWidthHistogram();
            }

            float currHistogramHeight = dataAreaHeight *
                    (params.getDatasHistogram().get(i).getData() / params.getMaxDataHistogram()) *
                    histogramProportion;
            float startY = params.getMarginTop() + itemMarginOnY / 2 + dataAreaHeight - currHistogramHeight;
            float stopY = getHeight() - params.getMarginBottom();

            canvas.drawRect(startX, startY, stopX, stopY, params.getPaintHistogram());

            if (histogramProportion >= 1.0f) {//0.999964是什么鬼？

                String textAbove = params.getDatasHistogram().get(i).getTextAbove();
                if (textAbove == null) {
                    continue;
                }
                float textMarginBottom = DisplayUtil.dip2px(params.getmContext(), 2);
                float textWidth = ViewUtil.getTextWidth(textAbove, params.getPaintData());

                canvas.drawText(textAbove,
                        startX + params.getWidthHistogram() / 2 - textWidth / 2,
                        startY - textMarginBottom,
                        params.getPaintData());

            }
        }

    }

    //线形图及数据文本
    private void drawLineGraph(Canvas canvas) {

        if (params.getDatasLine() == null || params.getDatasLine().size() == 0) {
            return;
        }

        int maxDataCount = params.getMaxDataCountLine();
        float itemMarginX, firstDataMargin;
        if (params.isxFromZero()) {
            itemMarginX = (getWidth() - params.getMarginLeft() - params.getMarginRight()
                    - params.getWidthHistogram() / 2)
                    / (maxDataCount - 0.5f);
            firstDataMargin = params.getWidthHistogram() / 2;
        } else {
            itemMarginX = (getWidth() - params.getMarginLeft() - params.getMarginRight())
                    / maxDataCount;
            firstDataMargin = itemMarginX / 2;
        }

        if (histogramProportion >= 1.0f || histogramProportion == 0) {
            linePath.reset();
        }

        int ordinates = params.getOrdinates().size();
        float itemMarginY = (getHeight() - params.getMarginBottom() - params.getMarginTop())
                / (params.getOrdinates().size() - 0.5f);
        float dataAreaHeight = (getHeight() - params.getMarginTop() - params.getMarginBottom()) * ((ordinates - 1f) / (ordinates - 0.5f));

        int dataLength = params.getDatasLine().size();
        //当提供的数据量超过所能显示的最大数据个数时，只显示最多支持的个数
        dataLength = dataLength < maxDataCount ? dataLength : maxDataCount;

        for (int i = 0; i < dataLength; i++) {

            float x1 = params.getMarginLeft() + firstDataMargin + itemMarginX * i;
            float currLineDataHeight1 = dataAreaHeight *
                    (params.getDatasLine().get(i).getData() / params.getMaxDataLine());
            float y1 = params.getMarginTop() + itemMarginY / 2 + dataAreaHeight - currLineDataHeight1;

            //当柱形图正在动画上升的时候，不重新定义linePath
            if (i < dataLength - 1 && (histogramProportion >= 1.0f || histogramProportion == 0)) {
                float x2 = params.getMarginLeft() + firstDataMargin + itemMarginX * (i + 1);
                float currLineDataHeight2 = dataAreaHeight *
                        (params.getDatasLine().get(i + 1).getData() / params.getMaxDataLine());
                float y2 = params.getMarginTop() + itemMarginY / 2 + dataAreaHeight - currLineDataHeight2;

                float midx = (x1 + x2) / 2;
                linePath.moveTo(x1, y1);
                linePath.cubicTo(midx, y1, midx, y2, x2, y2);
            }
        }
        canvas.drawPath(linePath, params.getPaintLine());
    }

}
