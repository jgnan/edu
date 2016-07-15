package org.shenit.anotherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.bind(this,R.id.send_broadcast_example_link,SendBroadcastExampleActivity.class);
    }
}
