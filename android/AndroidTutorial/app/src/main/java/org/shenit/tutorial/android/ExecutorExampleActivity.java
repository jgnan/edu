package org.shenit.tutorial.android;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExampleActivity extends AppCompatActivity {
    TextView content;
    Handler handler = new Handler();
    Executor exec = Executors.newSingleThreadExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_content);
        content = (TextView) findViewById(R.id.content);

//        StringBuffer buff = new StringBuffer();
//        try {
//            URL url = new URL("http://www.baidu.com");
//            InputStream is = url.openStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            String line;
//            while((line = reader.readLine()) != null) buff.append(reader.readLine());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String resp = buff.toString();
//        content.setText(resp);

        loadContent();
    }

    private void loadContent() {
        exec.execute(new Runnable(){
            @Override
            public void run() {
                StringBuffer buff = new StringBuffer();
                try {
                    URL url = new URL("http://www.baidu.com");
                    InputStream is = url.openStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while((line = reader.readLine()) != null) buff.append(reader.readLine());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final String resp = buff.toString();
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        content.setText(resp);
                    }
                });
            }
        });
    }


}
