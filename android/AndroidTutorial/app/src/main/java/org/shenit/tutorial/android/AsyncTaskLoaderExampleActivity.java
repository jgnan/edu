package org.shenit.tutorial.android;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.shenit.tutorial.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class AsyncTaskLoaderExampleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView contentText;
    private ProgressDialog progress;
    final private Bundle args = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_loader_example);
        contentText = (TextView) findViewById(R.id.content);
        Button reset = (Button) findViewById(R.id.reset);

        progress = ProgressDialog.show(this, "Loading", "Loading content, please wait...",true);
        args.putString("url", "http://www.baidu.com");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentText.setText("Reloading....");
                progress.show();
                getLoaderManager().restartLoader(0,args,AsyncTaskLoaderExampleActivity.this).forceLoad();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLoaderManager().initLoader(0, args, this).forceLoad();
    }



    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            public String loadInBackground() {
                StringBuffer buff = new StringBuffer();
                try {
                    URL url = new URL(args.getString("url"));
                    InputStream is = url.openStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while((line = reader.readLine()) != null) buff.append(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return buff.toString();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        this.contentText.setText(data);
        progress.dismiss();
        Toast.makeText(this,"Content loaded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
