package org.shenit.tutorial.android.services;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.Utils;

public class ServiceExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_examples);
        Utils.bind(this, R.id.simple_service_example_button, SimpleServiceExampleActivity.class);
        Utils.bind(this,R.id.bind_service_example_button,SimpleBindServiceExampleActivity.class);
        Utils.bind(this,R.id.intent_service_example_button,IntentServiceExampleActivity.class);
    }
}
