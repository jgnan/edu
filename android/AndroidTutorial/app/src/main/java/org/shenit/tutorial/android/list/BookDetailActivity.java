package org.shenit.tutorial.android.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.shenit.tutorial.android.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BookDetailActivity extends AppCompatActivity {
    private Handler handler = new Handler();
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer buff = new StringBuffer();
                try {
                    URL url = new URL("http://www.baidu.com");
                    InputStream is = url.openStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = reader.readLine()) != null) buff.append(reader.readLine());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final String resp = buff.toString();
                contentView.setText(resp);
            }
        }).start();
    }
}
