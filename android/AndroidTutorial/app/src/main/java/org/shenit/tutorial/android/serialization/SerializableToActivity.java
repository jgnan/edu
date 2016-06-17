package org.shenit.tutorial.android.serialization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.SerializableBook;

/**
 * 用Serializable实现序列化示例的跳转目标页面.
 */
public class SerializableToActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        //获取搜索条件里的参数
        Bundle bundle = getIntent().getExtras();

        SerializableBook book = (SerializableBook) bundle.getSerializable("record");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        TextView authorView = (TextView) findViewById(R.id.author);
        TextView contentView = (TextView) findViewById(R.id.content);

        titleTextView.setText(book.title);
        authorView.setText(book.author);
        contentView.setText(book.content);
    }
}
