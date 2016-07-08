package org.shenit.tutorial.android.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.shenit.tutorial.android.R;

public class SimpleServiceExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_service_example);
    }

    public void onStartServiceClick(View v){
        startService(new Intent(this, SimpleServiceExample.class));
    }

    public void onStopServiceClick(View v){
        stopService(new Intent(this, SimpleServiceExample.class));
    }
}
