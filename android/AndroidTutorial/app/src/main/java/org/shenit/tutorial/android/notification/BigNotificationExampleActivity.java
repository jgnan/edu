package org.shenit.tutorial.android.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.shenit.tutorial.android.R;

/**
 * 简单的通知示例.
 */
public class BigNotificationExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_notification_example);
    }

    public void onIssueNotificationClick(View v){
        //创建点击NOTIFICATION时跳转的活动
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(((BitmapDrawable)getDrawable(R.mipmap.small)).getBitmap())
                .setAutoCancel(true)
                .setContentTitle("Android Tutorial Notification")
                .setContentText("Content Text")
                .setCategory("Notification Category")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setSummaryText("This is the summary")
                        .setBigContentTitle("Big content title")
                        .bigText("This is a very very long content"));

        Intent resultIntent = new Intent(this,NotificationResultActivity.class);
        //set your data for the result activity here...

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_ONE_SHOT);

        builder.setContentIntent(pendingIntent);

        NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(01,builder.build());
    }
}
