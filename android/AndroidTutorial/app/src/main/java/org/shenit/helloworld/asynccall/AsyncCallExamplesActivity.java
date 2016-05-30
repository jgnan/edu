package org.shenit.helloworld.asynccall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.helloworld.AsyncTaskExampleActivity;
import org.shenit.helloworld.AsyncTaskLoaderExampleActivity;
import org.shenit.helloworld.ExecutorExampleActivity;
import org.shenit.helloworld.R;

import static org.shenit.helloworld.Utils.bind;

public class AsyncCallExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_examples);
        bind(this,R.id.executor_example_link, ExecutorExampleActivity.class);
        bind(this, R.id.async_task_example_link, AsyncTaskExampleActivity.class);
        bind(this, R.id.async_task_loader_example_link, AsyncTaskLoaderExampleActivity.class);
    }
}
