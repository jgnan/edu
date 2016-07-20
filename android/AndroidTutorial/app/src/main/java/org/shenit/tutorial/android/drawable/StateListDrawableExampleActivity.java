package org.shenit.tutorial.android.drawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.shenit.tutorial.android.R;

public class StateListDrawableExampleActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list_example);
        mButton = (Button) findViewById(R.id.button);
    }

    public void onSetSelected(View v){
        mButton.setSelected(true);
    }

    public void onSetUnselected(View v){
        mButton.setSelected(false);
    }

    public void onSetEnabled(View v){
        mButton.setEnabled(true);
    }

    public void onSetDisabled(View v){
        mButton.setEnabled(false);
    }
}
