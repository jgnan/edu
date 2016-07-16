package org.shenit.anotherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendBroadcastExampleActivity extends AppCompatActivity {
    private static final String ACTION = "org.shenit.tutorial.android.broadcast.EXPORTED";
    private EditText messageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast_example);
        messageText = (EditText) findViewById(R.id.message);
    }
    public void onSendBroadcastClick(View v){
        Intent intent = new Intent(ACTION);
        intent.putExtra("message", messageText.getText().toString());
        sendBroadcast(intent,"org.shenit.tutorial.android.broadcast.BROADCAST");
        Toast.makeText(this,"Send broadcast -> "+ ACTION,Toast.LENGTH_SHORT).show();
    }
}
