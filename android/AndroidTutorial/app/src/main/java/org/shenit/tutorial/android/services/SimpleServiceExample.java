package org.shenit.tutorial.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * A simple service to show life cycle of service.
 */
public class SimpleServiceExample extends Service{

    @Override
    public void onCreate() {
        Toast.makeText(SimpleServiceExample.this, "SimpleServiceExample.onCreate() called", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(SimpleServiceExample.this, "SimpleServiceExample.onStartCommand() called", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //we don't implement this method in this example
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(SimpleServiceExample.this, "SimpleServiceExample.onDestroy() called", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
