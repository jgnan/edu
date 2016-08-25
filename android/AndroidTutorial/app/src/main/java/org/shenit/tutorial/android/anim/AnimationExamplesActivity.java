package org.shenit.tutorial.android.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class AnimationExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_examples);

        TutorialUtils.bind(this,R.id.val_anim_example_button,ValueAnimatorExampleActivity.class);
        TutorialUtils.bind(this,R.id.obj_anim_example_button,ObjectAnimatorExampleActivity.class);
        TutorialUtils.bind(this,R.id.layout_anim_example_button,LayoutAnimationExampleActivity.class);
        TutorialUtils.bind(this,R.id.layout_anim_xml_example_button,LayoutAnimationByXmlExampleActivity.class);
    }
}
