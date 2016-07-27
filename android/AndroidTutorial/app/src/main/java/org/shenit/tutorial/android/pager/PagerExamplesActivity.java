package org.shenit.tutorial.android.pager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class PagerExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_examples);
        TutorialUtils.bind(this, R.id.view_pager_example_link, ViewPagerExampleActivity.class);
    }
}
