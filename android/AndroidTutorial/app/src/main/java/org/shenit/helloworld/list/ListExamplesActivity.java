package org.shenit.helloworld.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.helloworld.R;
import org.shenit.helloworld.Utils;

public class ListExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_examples);

        Utils.bind(this,R.id.array_adapter_example,ArrayAdapterExampleActivity.class);
    }
}
