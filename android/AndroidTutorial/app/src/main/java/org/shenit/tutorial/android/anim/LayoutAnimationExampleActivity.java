package org.shenit.tutorial.android.anim;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class LayoutAnimationExampleActivity extends AppCompatActivity {
    private ViewGroup vg;
    private ImageView img;
    private ObjectAnimator appearAnim;
    private ObjectAnimator disappearAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation_example);
        vg = (ViewGroup) findViewById(R.id.anim_code_layout);
        img = (ImageView) findViewById(R.id.img);


        appearAnim = ObjectAnimator.ofFloat(vg,"alpha",0.0f, 1.0f);
        appearAnim.setDuration(1000l);
        disappearAnim = ObjectAnimator.ofFloat(vg,"alpha",1.0f, 0.0f);
        disappearAnim.setDuration(1000l);

    }
    public void onButton1Click(View v){
        LayoutTransition trans = new LayoutTransition();
        trans.setAnimator(LayoutTransition.APPEARING,appearAnim);
        trans.setAnimator(LayoutTransition.DISAPPEARING,disappearAnim);
        vg.setLayoutTransition(trans);

        TutorialUtils.toggleInvisible(img);
    }

    public void onButton2Click(View v){
        LayoutTransition trans = new LayoutTransition();
        trans.setAnimator(LayoutTransition.CHANGE_APPEARING,appearAnim);
        trans.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,disappearAnim);
        vg.setLayoutTransition(trans);

        TutorialUtils.toggleInvisible(img);
    }
}
