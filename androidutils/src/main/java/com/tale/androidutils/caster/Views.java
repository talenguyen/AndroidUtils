package com.tale.androidutils.caster;

import android.app.Activity;
import android.view.View;

public final class Views {

    private Views() {
    }

    /**
     * Simpler version of {@link android.view.View#findViewById(int)} which infers the target type.
     */
    @SuppressWarnings({"unchecked", "UnusedDeclaration"})
    public static <T extends View> T findById(View view, int id) {
        return (T) view.findViewById(id);
    }

    /**
     * Simpler version of {@link android.app.Activity#findViewById(int)} which infers the target type.
     */
    @SuppressWarnings({"unchecked", "UnusedDeclaration"})
    public static <T extends View> T findById(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }

}

