package com.leonxtp.simplechartview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leonxtp.libsimplechart.ChartParams;
import com.leonxtp.libsimplechart.SimpleChartView;
import com.leonxtp.libsimplechart.config.ChartConfigure;
import com.leonxtp.libsimplechart.data.ChartData;
import com.leonxtp.libsimplechart.data.ChartDataAdapter;
import com.leonxtp.libsimplechart.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleChartView chartView = (SimpleChartView) findViewById(R.id.chartView);

        Random random = new Random();

        final List<ChartData> lineDatalist = new ArrayList<>();
        final List<ChartData> histogramDataList = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            ChartData linedata = new ChartData();
            int data1 = random.nextInt(120);
            linedata.setData(data1);
            linedata.setTextAbove("" + data1);
            lineDatalist.add(linedata);

            ChartData histodata = new ChartData();
            int data2 = random.nextInt(100);
            histodata.setData(data2);
            histodata.setTextAbove("" + data2);
            histogramDataList.add(histodata);
        }

        final List<String> abscissas = new ArrayList<>(5);
        abscissas.add("0");
        abscissas.add("1");
        abscissas.add("2");
        abscissas.add("3");
        abscissas.add("4");

        final List<String> ordinates = new ArrayList<>(5);
        ordinates.add("0");
        ordinates.add("20");
        ordinates.add("40");
        ordinates.add("60");
        ordinates.add("80");
        ordinates.add("100");

        ChartParams params = new ChartParams();
        params.with(this)
                .setConfigure(new ChartConfigure() {

                    @Override
                    public float[] getDataAreaMargins() {
                        return new float[]{DisplayUtil.dip2px(MainActivity.this, 32),
                                DisplayUtil.dip2px(MainActivity.this, 24),
                                DisplayUtil.dip2px(MainActivity.this, 32),
                                DisplayUtil.dip2px(MainActivity.this, 30)};
                    }

                    @Override
                    public float getTextSizeAbscissa() {
                        return DisplayUtil.sp2px(MainActivity.this, 12);
                    }

                    @Override
                    public float getTextSizeOrdinate() {
                        return DisplayUtil.sp2px(MainActivity.this, 12);
                    }

                    @Override
                    public float getTextSizeData() {
                        return DisplayUtil.sp2px(MainActivity.this, 12);
                    }

                    @Override
                    public int getColorText() {
                        return Color.WHITE;
                    }

                    @Override
                    public int getColorLine() {
                        return Color.YELLOW;
                    }

                    @Override
                    public int getColorHistogram() {
                        return Color.GREEN;
                    }

                    @Override
                    public float getWidthLine() {
                        return DisplayUtil.dip2px(MainActivity.this, 1);
                    }

                    @Override
                    public float getWidthHistogram() {
                        return DisplayUtil.dip2px(MainActivity.this, 16);
                    }

                    @Override
                    public boolean isxFromZero() {
                        return false;
                    }
                })
                .setDataAdapter(new ChartDataAdapter() {

                    @Override
                    public int getMaxDataCountLine() {
                        return 14;
                    }

                    @Override
                    public int getMaxDataCountHistogram() {
                        return 14;
                    }

                    @Override
                    public int getAbscissaCount() {
                        return 5;
                    }

                    @Override
                    public String getAbscissa(int position) {
                        return abscissas.get(position);
                    }

                    @Override
                    public String getAbscissaSecondary(int position) {
                        return null;
                    }

                    @Override
                    public int getOrdinateCount() {
                        return 6;
                    }

                    @Override
                    public String getOrdinate(int position) {
                        return ordinates.get(position);
                    }

                    @Override
                    public String getXaxisDescription() {
                        return "日期";
                    }

                    @Override
                    public String getYaxisDescription() {
                        return "数量";
                    }

                    @Override
                    public float getMaxDataLine() {
                        return 120;
                    }

                    @Override
                    public float getMaxDataHistogram() {
                        return 100;
                    }

                    @Override
                    public int getDataCountLine() {
                        return 14;
                    }

                    @Override
                    public int getDataCountHistogram() {
                        return 14;
                    }

                    @Override
                    public ChartData getDataLine(int position) {
                        return lineDatalist.get(position);
                    }

                    @Override
                    public ChartData getDataHistogram(int position) {
                        return histogramDataList.get(position);
                    }
                })
                .build();

//        params.with(this)
//                .setAbscissas(abscissas)
//                .setOrdinates(ordinates)
//                .setyAxisDescription("数量")
//                .setxAxisDescription("日期")
//
//                .setIsxFromZero(false)
//
//                .setWidthHistogram(DisplayUtil.dip2px(this, 24))
//
//                .setMaxDataCountHistogram(5)
//                .setMaxDataCountLine(5)
//                .setMaxDataLine(120)
//                .setMaxDataHistogram(100)
//
//                .setColorText(Color.RED)
//                .setColorHistogram(Color.GRAY)
//                .setColorLine(Color.WHITE)
//
//                .setDatasHistogram(histogramDataList)
//                .setDatasLine(lineDatalist)
//                .build();

        chartView.updateParams(params);


    }
}
