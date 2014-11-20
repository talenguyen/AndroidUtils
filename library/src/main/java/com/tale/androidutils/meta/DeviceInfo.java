package com.tale.androidutils.meta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;

import java.io.File;

/**
 * Created by TALE on 9/8/2014.
 */
public class DeviceInfo {
    public final int screen_W;
    public final int screen_H;
    public final float density;
    public final float scaledDensity;
    public final int densityDpi;

    private final Context context;

    private static DeviceInfo sInstance;

    public DeviceInfo(Application context) {
        this.context = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        density = displayMetrics.density;
        densityDpi = displayMetrics.densityDpi;
        scaledDensity = displayMetrics.scaledDensity;
        screen_W = displayMetrics.widthPixels;
        screen_H = displayMetrics.heightPixels;
    }

    public static synchronized DeviceInfo getInstance(Application context) {
        if (sInstance == null) {
            sInstance = new DeviceInfo(context);
        }
        return sInstance;
    }

    /**
     * Get available storage to write file.
     *
     * @return {@link java.io.File} object represent for available storage directory.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public File getAvailableFileDirectory() {
        if (isExternalStorageWritable()) {
            return context.getExternalFilesDir(null);
        } else {
            return context.getFilesDir();
        }
    }

    /**
     * Get available storage to write file.
     *
     * @return {@link java.io.File} object represent for available storage directory.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public File getAvailableCacheDirectory() {
        if (isExternalStorageWritable()) {
            return context.getExternalCacheDir();
        } else {
            return context.getCacheDir();
        }
    }

    /**
     * Checks if external storage is available for read and write
     *
     * @return <b>true</b> it's available or <b>false</b> otherwise.
     */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is any connectivity
     *
     * @return <b>true</b> if network is connected or <b>false</b> otherwise.
     */
    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }
}
