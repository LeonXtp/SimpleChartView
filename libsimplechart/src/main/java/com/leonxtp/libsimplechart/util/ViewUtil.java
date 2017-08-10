package com.leonxtp.libsimplechart.util;

import android.graphics.Paint;

/**
 * Created by leonxtp on 2017/7/28.
 */

public class ViewUtil {


    public static float getTextHeightByPaint(Paint mPaint) {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        return (float) Math.ceil(fm.descent - fm.ascent);
    }

    public static double getTextHeight(Paint mPaint) {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        return Math.ceil(fm.descent - fm.ascent);
    }

    public static float getTextWidth(String strings, Paint p) {
        if (strings == null) {
            return 0;
        }
        float maxWidthF = 0.0f;
        float width = p.measureText(strings);
        maxWidthF = Math.max(width, maxWidthF);
        int maxWidth = (int) (maxWidthF + 0.5);
        if (maxWidth < 0) {
            maxWidth = 0;
        }
        return maxWidth;
    }

}
