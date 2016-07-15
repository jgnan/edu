package org.shenit.tutorial.android.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.Utils;

public class NotificationExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_eamples);
        Utils.bind(this, R.id.simple_notification_example_button, SimpleNotificationExampleActivity.class);
        Utils.bind(this, R.id.big_notification_example_button, BigNotificationExampleActivity.class);
    }
}
