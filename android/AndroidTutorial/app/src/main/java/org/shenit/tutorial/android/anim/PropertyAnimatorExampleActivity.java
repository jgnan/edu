package org.shenit.tutorial.android.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import org.shenit.tutorial.android.R;

public class PropertyAnimatorExampleActivity extends AppCompatActivity {
    private Spinner animators;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator_example);
        animators = (Spinner) findViewById(R.id.animators);
        img = (ImageView) findViewById(R.id.img);
        animators.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,new String[]{"alpha","translate","scale","rotate","set"}));
    }

    public void onGoClick(View v){
        String item = (String) animators.getSelectedItem();
        Animator animator = null;
        if(item == "set"){
            AnimatorSet set = new AnimatorSet();
            Animator appear = ObjectAnimator.ofFloat(img,"alpha",0.0f,1.0f).setDuration(2000);
            Animator disappear = ObjectAnimator.ofFloat(img,"alpha",1.0f,0.0f).setDuration(2000);
            Animator scale = ObjectAnimator.ofFloat(img,"scaleX",1.0f,0.5f,1.0f).setDuration(2000);
            Animator up = ObjectAnimator.ofFloat(img,"y",0).setDuration(3000);
            Animator down = ObjectAnimator.ofFloat(img,"y",500).setDuration(2000);

            set.play(appear)
                    .with(down)
                    .with(scale)
                    .before(up);
            set.play(disappear)
                    .with(up)
                    .after(appear);
            animator = set;
        }else {
            int animatorId = getResources().getIdentifier(item + "_animator", "animator", getPackageName());
            animator = AnimatorInflater.loadAnimator(this, animatorId);
        }
        animator.setTarget(img);
        animator.start();
    }
}
