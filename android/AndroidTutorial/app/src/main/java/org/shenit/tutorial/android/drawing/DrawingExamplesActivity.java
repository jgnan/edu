package org.shenit.tutorial.android.drawing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

/**
 * Drawing relative topics.
 */
public class DrawingExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_examples);
        TutorialUtils.bind(this,R.id.canvas_example,CanvasExampleActivity.class);
        TutorialUtils.bind(this,R.id.surface_view_example,SurfaceViewExampleActivity.class);

    }
}
