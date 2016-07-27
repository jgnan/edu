package org.shenit.tutorial.android.customization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

/**
 * 各种组件示例
 */
public class CustomizationExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_examples);
        TutorialUtils.bind(this,R.id.simple_customize_comp_example, SimpleCustomizeComponentExampleActivity.class);
    }
}
