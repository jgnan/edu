package org.shenit.tutorial.android.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.shenit.tutorial.android.R;

public class ObjectAnimatorExampleActivity extends AppCompatActivity {
    private boolean mStarted = false;
    private Button mButton;
    private ImageView mImg;
    private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator_example);
        mImg = (ImageView) findViewById(R.id.drawable);
        mButton = (Button) findViewById(R.id.button);
        animator = ObjectAnimator.ofFloat(mImg,"alpha",0f,1f,0f);
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mButton.setText("Stop");
                mStarted = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mButton.setText("Start");
                mStarted = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mButton.setText("Start");
                mStarted = false;
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                animation.start();
            }
        });
    }

    public void onStartClick(View v){
        animator.start();
    }
}
