package org.shenit.tutorial.android.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class SimpleBindServiceExampleActivity extends AppCompatActivity {
    private TextView mTimestampText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_bind_service_example);
        mTimestampText = (TextView) findViewById(R.id.timestamp_text);
    }

    public void onBindServiceClick(View v){
        bindService(new Intent(this, SimpleBindServiceExample.class), mConn, Context.BIND_AUTO_CREATE);
    }

    public void onStartServiceClick(View v){
        startService(new Intent(this,SimpleBindServiceExample.class));
    }

    public void onUnbindServiceClick(View v){
        unbindService(mConn);
    }

    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(SimpleBindServiceExampleActivity.this, "onServiceConnected() called", Toast.LENGTH_SHORT).show();
            ((SimpleBindServiceExample.SimpleServiceBinder) service).registerCurrentText(mTimestampText);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(SimpleBindServiceExampleActivity.this, "onServiceDisconnected() called", Toast.LENGTH_SHORT).show();
        }
    };

}
