package org.shenit.tutorial.android.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class IntentServiceExampleActivity extends AppCompatActivity {
    private EditText msgCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_example);
        msgCountText = (EditText) findViewById(R.id.message_count);
    }

    public void onSendMessage(View v){
        String msg = msgCountText.getText().toString();
        int count = 1;
        if(TextUtils.isDigitsOnly(msg) && !TextUtils.isEmpty(msg)) count = Integer.parseInt(msg);
        else {
            Toast.makeText(this, "No message to send!", Toast.LENGTH_SHORT).show();
            return;
        }
        //start intent for {count} times
        for(int i =0; i< count; i++){
            Intent intent = new Intent(this,IntentServiceExample.class);
            intent.putExtra("index",i);
            intent.putExtra("message","Message to send ["+ i+"]");
            startService(intent);
        }
    }
}
