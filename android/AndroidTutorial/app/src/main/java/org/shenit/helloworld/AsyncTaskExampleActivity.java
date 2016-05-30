package org.shenit.helloworld;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.CharBuffer;

public class AsyncTaskExampleActivity extends AppCompatActivity {
    TextView content;
    MyTask task = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_content);
        content = (TextView) findViewById(R.id.content);
    }

    @Override
    protected void onResume() {
        super.onResume();
        task = new MyTask();
        task.execute("http://www.baidu.com");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(task != null && !task.isCancelled()) task.cancel(true);
        task = null;
    }

    class MyTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params) {
            StringBuffer buff = new StringBuffer();
            try {
                Thread.sleep(30000);    //延迟30S执行网络加载代码
                URL url = new URL(params[0]);
                InputStream is = url.openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                while((line = reader.readLine()) != null) buff.append(reader.readLine());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return buff.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            content.setText(s);
        }
    };
}
