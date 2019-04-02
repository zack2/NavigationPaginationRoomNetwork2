package com.olivierloukombo.navigationpaginationroomnetwork;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

import androidx.core.widget.NestedScrollView;

public class Utils {
    public static int dpToPx(Context c, int dp) {
        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
