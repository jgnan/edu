package org.shenit.tutorial.android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 简单的通知实现类.
 */
public class SimpleBroadcastReceiver extends BroadcastReceiver{
    public final static String ACTION = "org.shenit.tutorial.android.SIMPLE_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SimpleBroadcastReceiver","WE RECEIVE AN INTENT !"+intent);
    }
}
