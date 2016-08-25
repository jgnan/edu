package org.shenit.tutorial.android.anim;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class LayoutAnimationByXmlExampleActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation_xml_example);
        img = (ImageView) findViewById(R.id.img);

    }
    public void onToggleVisibleClick(View v){
        TutorialUtils.toggleInvisible(img);
    }
}
