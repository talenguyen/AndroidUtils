package com.tale.androidutils.tasks;

import android.os.Handler;

/**
 * Created by tale on 11/22/14.
 */
public class Timer {

    private final Handler mHandle;
    private final Runnable mTimerTask;
    private final long mPeriod;

    public Timer(Handler handle, final Runnable task, final long period) {
        if (handle == null) {
            throw new IllegalArgumentException("handle must not be null");
        }

        if (task == null) {
            throw new IllegalArgumentException("task must not be null");
        }

        if (period <= 0) {
            throw new IllegalArgumentException("delay can not be negative value");
        }
        mPeriod = period;
        mHandle = handle;
        mTimerTask = new Runnable() {
            @Override public void run() {
                task.run();
                mHandle.postDelayed(this, period);
            }
        };
    }

    public void start() {
        stop();
        mHandle.post(mTimerTask);
    }

    public void resume() {
        stop();
        mHandle.postDelayed(mTimerTask, mPeriod);
    }

    public void startDelay(long delay) {
        stop();
        mHandle.postDelayed(mTimerTask, delay);
    }

    public void stop() {
        mHandle.removeCallbacks(mTimerTask);
    }

}
