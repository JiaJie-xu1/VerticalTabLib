package com.partner.tabtools.verticalTab;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author JayXu
 */

public class DisplayUtil {
    private static final double r1 = 1d / 360d;
    public static DisplayMetrics SCREEN_INFO;

    public static int getSR(int unit) {
        if (SCREEN_INFO== null) {
            return 0;
        }
        int v = (int) (SCREEN_INFO.widthPixels * r1 * unit);
        return v;
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
