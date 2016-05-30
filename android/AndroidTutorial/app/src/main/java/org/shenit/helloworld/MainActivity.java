package org.shenit.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.helloworld.asynccall.AsyncCallExamplesActivity;
import org.shenit.helloworld.dataproc.DataProcessExamples;
import org.shenit.helloworld.drawable.DrawableMainActivity;

import static org.shenit.helloworld.Utils.bind;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind(this, R.id.interact_example_link, InteractExampleActivity.class);
        bind(this,R.id.list_example_link, ListExampleActivity.class);
        bind(this,R.id.drawable_examples_link, DrawableMainActivity.class);
        bind(this,R.id.async_call_examples_link, AsyncCallExamplesActivity.class);
        bind(this, R.id.act_life_cycle_example_link, ActivityLifeCycleExampleActivity.class);
        bind(this,R.id.data_process_examples, DataProcessExamples.class);
    }
}
