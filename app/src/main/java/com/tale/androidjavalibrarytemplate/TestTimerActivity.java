package com.tale.androidjavalibrarytemplate;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.tale.androidutils.caster.Views;
import com.tale.androidutils.tasks.Timer;

/**
 * Created by tale on 11/23/14.
 */
public class TestTimerActivity extends Activity {

    private static final String TAG = TestTimerActivity.class.getSimpleName();

    Timer timer;
    private int count = 0;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        final TextView tvDisplay = Views.findById(this, R.id.tvDisplay);
        timer = new Timer(new Handler(Looper.getMainLooper()), new Runnable() {
            @Override public void run() {
                Log.d(TAG, "count: " + count);
                count++;
                tvDisplay.setText(String.valueOf(count));
            }
        }, 1000);
        timer.start();
    }

    @Override protected void onResume() {
        super.onResume();
        timer.resume();
    }

    @Override protected void onPause() {
        super.onPause();
        timer.stop();
    }
}
