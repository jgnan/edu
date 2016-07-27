package org.shenit.tutorial.android.components;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.drawable.RemoteDrawableExampleActivity;

import static org.shenit.tutorial.android.TutorialUtils.bind;

/**
 * 各种组件示例
 */
public class ComponentExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_examples);

        bind(this, R.id.remote_drawable_example_link, RemoteDrawableExampleActivity.class);
    }
}
