package org.shenit.tutorial.android.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.Utils;

public class FragmentExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_examples);
        Utils.bind(this, R.id.simple_fragment_example_link, SimpleFragmentExampleActivity.class);
        Utils.bind(this, R.id.life_cycle_example_link,LifeCycleExampleActivity.class );
    }
}
