package org.shenit.tutorial.android.asynccall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;

import static org.shenit.tutorial.android.Utils.bind;

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
