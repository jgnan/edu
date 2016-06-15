package org.shenit.tutorial.android.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.shenit.tutorial.android.R;

public class BookDetailActivity extends AppCompatActivity {
    TextView contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String author = bundle.getString("author");
        String content = bundle.getString("content");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        TextView authorView = (TextView) findViewById(R.id.author);
        contentView = (TextView) findViewById(R.id.content);

        titleTextView.setText(title);
        authorView.setText(author);
        contentView.setText(content);
    }
}
