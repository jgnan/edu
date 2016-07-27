package org.shenit.tutorial.android.fixscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class FixScreenExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_screen_examples);
        TutorialUtils.bind(this, R.id.fix_multi_screen_example, FixMultiScreenExampleActivity.class);
        TutorialUtils.bind(this, R.id.styling_example, StylingExampleActivity.class);
        TutorialUtils.bind(this, R.id.orientation_change_example, OrientationChangeExampleActivity.class);
        TutorialUtils.bind(this, R.id.sensor_portrait_example, SensorPortraitExampleActivity.class);
    }
}
