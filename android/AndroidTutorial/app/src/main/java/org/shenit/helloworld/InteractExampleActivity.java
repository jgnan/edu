package org.shenit.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class InteractExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact_example);
        final TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText("Title set by code!!");
        getResources().getDrawable(R.mipmap.ic_launcher,null);

        Button button = (Button) findViewById(R.id.button);
        final AtomicInteger count = new AtomicInteger(0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleView.setText("Click count -> " + count.incrementAndGet());
            }
        });
    }
}
