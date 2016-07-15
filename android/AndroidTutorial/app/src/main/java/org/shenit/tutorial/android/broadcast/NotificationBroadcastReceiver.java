package org.shenit.tutorial.android.broadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.notification.NotificationResultActivity;

/**
 * 供外部使用的广播接收类.
 */
public class NotificationBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //创建点击NOTIFICATION时跳转的活动
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)        //set to true then notification will cancel itself once clicked
                .setContentTitle("Android Tutorial Notification")
                .setNumber(10)      //notification count
                .setContentText("We receive data -> "+intent.getStringExtra("message"));

        Intent resultIntent = new Intent(context,NotificationResultActivity.class);
        //set your data for the result activity here...

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_ONE_SHOT);

        builder.setContentIntent(pendingIntent);

        NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(01,builder.build());
    }
}
