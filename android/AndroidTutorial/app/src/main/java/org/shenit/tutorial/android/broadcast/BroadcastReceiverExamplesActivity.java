package org.shenit.tutorial.android.broadcast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class BroadcastReceiverExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_examples);
        TutorialUtils.bind(this, R.id.simple_broadcast_example_button, SimpleBroadcastExampleActivity.class);
    }
}
