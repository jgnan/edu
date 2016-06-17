package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

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
        //在应用的目录中获取一个叫helloworld的SharedPreferences存储文件的数据
        SharedPreferences sp = getSharedPreferences("helloworld",Context.MODE_PRIVATE);
        //获取一个可修改的实例，启用修改方法
        sp.edit()
                .putString("title",titleText.getText().toString())
                .putString("content",contentText.getText().toString())
                //把变更内容先更新到内存，再异步写到文件系统
                .apply();
        Toast.makeText(this, "Save data to user preferences done", Toast.LENGTH_SHORT).show();
    }

    private void loadFromSharedPreferences() {
        //获取应用目录中一个叫helloworld的SharedPreferences存储文件的数据
        SharedPreferences sp = getSharedPreferences("helloworld",Context.MODE_PRIVATE);
        //读取这个文件中的值，第二个参数是如果值不存在时说使用的默认值
        titleText.setText(sp.getString("title",null));
        contentText.setText(sp.getString("content",null));
        Toast.makeText(this, "Load data from user preferences done", Toast.LENGTH_SHORT).show();
    }
}
