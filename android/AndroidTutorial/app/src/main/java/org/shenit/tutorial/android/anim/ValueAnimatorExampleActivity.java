package org.shenit.tutorial.android.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.shenit.tutorial.android.R;

public class ValueAnimatorExampleActivity extends AppCompatActivity {
    private ValueAnimator mAnimation;
    private TextView mText;
    private Button mButton;
    private boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_value_animator_example);
        mText = (TextView) findViewById(R.id.counter);
        mButton = (Button) findViewById(R.id.button);

        //initialize our animation
        mAnimation = ValueAnimator.ofInt(0,100);
        mAnimation.setDuration(1000);
        //this only listener the value changed event.
        mAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mText.setText(animation.getAnimatedValue().toString());
            }
        });
        //Listen animation events
        mAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mButton.setText("Stop");
                started = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mButton.setText("Start");
                started = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mButton.setText("Start");
                mText.setText("00");
                started = false;
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void onStartClick(View v){
        if(!started) {
            mAnimation.start();
        }else{
            mAnimation.cancel();
        }
    }

}
