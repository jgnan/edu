package org.shenit.tutorial.android.dataprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;

import static org.shenit.tutorial.android.TutorialUtils.bind;

public class DataProviderExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_provider_examples);
        bind(this, R.id.simple_data_provider_example_link, SimpleDataProviderExampleActivity.class);
        bind(this, R.id.cursor_loader_example_link,CursorLoaderExampleActivity.class);
        bind(this, R.id.contact_data_provider_example_link,ContactDataProviderExampleActivity.class);
    }
}
