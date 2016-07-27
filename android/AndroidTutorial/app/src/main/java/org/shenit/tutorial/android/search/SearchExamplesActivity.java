package org.shenit.tutorial.android.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class SearchExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_examples);
        TutorialUtils.bind(this, R.id.search_dialog_example_button, SearchDialogExampleActivity.class);
        TutorialUtils.bind(this, R.id.search_view_ab_example_button, SearchViewActionbarExampleActivity.class);
    }
}
