package org.shenit.tutorial.android.drawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class LevelDrawableExampleActivity extends AppCompatActivity {
    private EditText mLevelText;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_drawable);
        mButton = (Button) findViewById(R.id.button);
        mLevelText = (EditText) findViewById(R.id.level_text);
    }

    public void onChangeLevel(View v){
        String levelStr = mLevelText.getText().toString();
        int level = 0;
        if(TextUtils.isDigitsOnly(levelStr) && levelStr != null) level = Integer.parseInt(levelStr);

        mButton.getBackground().setLevel(level);
        Toast.makeText(this, "Change to level -> "+level, Toast.LENGTH_SHORT).show();
    }
}
