package org.shenit.tutorial.android.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class SimpleBroadcastExampleActivity extends AppCompatActivity {
    private SimpleBroadcastReceiver simpleReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_broadcast_example);
        simpleReceiver = new SimpleBroadcastReceiver();
    }

    public void onRegisterReceiverClick(View v){
        registerReceiver(simpleReceiver,new IntentFilter(SimpleBroadcastReceiver.ACTION));
        Toast.makeText(this,"Receiver register for -> "+SimpleBroadcastReceiver.ACTION, Toast.LENGTH_SHORT).show();
    }

    public void onUnregisterReceiverClick(View v){
        unregisterReceiver(simpleReceiver);
        Toast.makeText(this,"Receiver unregister for -> "+SimpleBroadcastReceiver.ACTION, Toast.LENGTH_SHORT).show();
    }

    public void onSendBroadcastClick(View v){
        sendBroadcast(new Intent(SimpleBroadcastReceiver.ACTION));
        Toast.makeText(this,"Send intent -> "+SimpleBroadcastReceiver.ACTION, Toast.LENGTH_SHORT).show();
    }
}
