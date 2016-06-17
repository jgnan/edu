package org.shenit.tutorial.android.serialization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.SerializableBook;

/**
 * 用Serializable实现序列化示例的开始页面.
 */
public class SerializableFromActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable_from_page);
    }

    public void onJump(View view){
        Intent intent = new Intent(this,SerializableToActivity.class);
        Bundle bundle = new Bundle();
        SerializableBook book = new SerializableBook("Serializable Book","Mr. Jiang",new java.util.Date(),"It's a test!");
        bundle.putSerializable("record",book);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
