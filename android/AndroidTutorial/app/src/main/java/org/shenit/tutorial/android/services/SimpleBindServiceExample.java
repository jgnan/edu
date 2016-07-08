package org.shenit.tutorial.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个简单的onBind()例子
 */
public class SimpleBindServiceExample extends Service{
    //date format for display date time pattern
    private static final SimpleDateFormat FMT = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
    private SimpleServiceBinder mBinder;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private boolean mBound = false;
    private TextView mTimestampText;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        mBinder = new SimpleServiceBinder();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
            while (mBound) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                }
                //update each second
                mHandler.post(updateCurrentRunner);
            }
            }
        });
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(SimpleBindServiceExample.this, "onBind() called", Toast.LENGTH_SHORT).show();
        mBound = true;
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(SimpleBindServiceExample.this, "onUnbind() called", Toast.LENGTH_SHORT).show();
        mExecutor.shutdownNow();
        mBound = false;
        mTimestampText.setText("");
        mTimestampText = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(SimpleBindServiceExample.this, "SimpleServiceExample.onDestroy() called", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    /**
     * Runner to update current timestamp text field in UI
     */
    private Runnable updateCurrentRunner = new Runnable(){
        @Override
        public void run() {
            if (mTimestampText != null) mTimestampText.setText(FMT.format(new Date()));
        }
    };

    public class SimpleServiceBinder extends Binder{
        public void registerCurrentText(TextView mTimestampText) {
            SimpleBindServiceExample.this.mTimestampText = mTimestampText;
        }
    }
}