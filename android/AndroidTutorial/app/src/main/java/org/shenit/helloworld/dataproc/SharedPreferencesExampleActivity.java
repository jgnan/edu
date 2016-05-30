package org.shenit.helloworld.dataproc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.helloworld.R;

public class SharedPreferencesExampleActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);
        titleText = (EditText) findViewById(R.id.title);
        contentText = (EditText) findViewById(R.id.content);
        Button saveBtn = (Button) findViewById(R.id.save);
        Button loadBtn = (Button) findViewById(R.id.load);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToSharedPreferences();
            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromSharedPreferences();
            }
        });
    }

    private void saveToSharedPreferences() {
        SharedPreferences sp = getSharedPreferences("helloworld",Context.MODE_PRIVATE);
        sp.edit()
                .putString("title",titleText.getText().toString())
                .putString("content",contentText.getText().toString())
                .commit();
        Toast.makeText(this, "Save data to user preferences done", Toast.LENGTH_SHORT).show();
    }

    private void loadFromSharedPreferences() {
        SharedPreferences sp = getSharedPreferences("helloworld",Context.MODE_PRIVATE);
        titleText.setText(sp.getString("title",null));
        contentText.setText(sp.getString("content",null));
        Toast.makeText(this, "Load data from user preferences done", Toast.LENGTH_SHORT).show();
    }
}
