package com.tale.androidutils.meta;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/**
 * Created by TALE on 10/7/2014.
 */
public class CompatibleHelper {

    public static void setBackgroundDrawable(View target, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            target.setBackground(drawable);
        } else {
            target.setBackgroundDrawable(drawable);
        }
    }
}
