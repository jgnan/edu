package org.shenit.tutorial.android.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class ViewAnimExamplesActivity extends AppCompatActivity {
    private Spinner effects;
    private Spinner interpolators;
    private Spinner repeatModes;
    private EditText duration;
    private EditText factor;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim_examples);

        effects = (Spinner) findViewById(R.id.effects);
        interpolators = (Spinner) findViewById(R.id.interpolators);
        img = (ImageView) findViewById(R.id.img);
        duration = (EditText) findViewById(R.id.duration);
        factor = (EditText) findViewById(R.id.factor);
        repeatModes = (Spinner) findViewById(R.id.repeat_modes);
        effects.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getTextArray(R.array.anim_effects)));
        interpolators.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getTextArray(R.array.interpolators)));
        repeatModes.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,new String[]{"none","infinite","restart","reverse"}));
    }

    public void onTakeEffectClick(View v){
        String item = (String)effects.getSelectedItem();

        int animId = getResources().getIdentifier(item+"_example","anim",getPackageName());
        Animation anim = AnimationUtils.loadAnimation(this,animId);
        anim = setInterpolator(anim);
        String durStr = duration.getText().toString();
        if(TextUtils.isDigitsOnly(durStr) && !durStr.isEmpty()) anim.setDuration(Long.parseLong(durStr));
        Toast.makeText(this,"Effect: "+item+", duration: "+durStr+
                ", interpolator: "+interpolators.getSelectedItem()+
                ", factory: "+factor.getText().toString(),Toast.LENGTH_LONG).show();
        img.startAnimation(anim);

    }

    public Animation setInterpolator(Animation animation) {
        String interpolator = (String) interpolators.getSelectedItem();
        setStartMode(animation);
        String factStr = factor.getText().toString();
        Float fact =
                TextUtils.isEmpty(factStr) ? null : Float.parseFloat(factStr);
        switch(interpolator){
            case "accelerate":
                //create by code
                animation.setInterpolator(new AccelerateInterpolator(fact == null ? 1.0f : fact));break;
            case "decelerate":
                //calling from anroid package
                animation.setInterpolator(this,android.R.anim.decelerate_interpolator);break;
            case "accelerateDecelerate":
                //calling from anim/ folder
                animation.setInterpolator(this,R.anim.acce_dec_interpolator);break;
            case "anticipate":
                animation.setInterpolator(new AnticipateInterpolator(fact == null ? 2.0f : fact));break;
            case "overshoot":
                animation.setInterpolator(new OvershootInterpolator(fact == null ? 2.0f : fact));break;
            case "anticipateOverShoot":
                animation.setInterpolator(new AnticipateOvershootInterpolator(fact == null ? 2.0f * 1.5f : fact));break;
            case "bounce":
                animation.setInterpolator(new BounceInterpolator());break;
            case "cycle":
                animation.setInterpolator(new CycleInterpolator(fact == null ? 1.0f : fact));break;
            case "customize":
                animation.setInterpolator(new MyInterpolator());break;
        }
        return animation;
    }

    private void setStartMode(Animation animation) {
        String repeat = (String) repeatModes.getSelectedItem();

        switch(repeat){
            case "restart":
                animation.setRepeatCount(1);
                break;
            case "infinite":
                animation.setRepeatCount(Animation.INFINITE);
                break;
            case "reverse":
                animation.setRepeatMode(Animation.REVERSE);
                animation.setRepeatCount(1);
                break;
        }
    }

    /**
     * Customize interpolator must implement the Interpolator interface
     */
    private class MyInterpolator implements Interpolator{

        @Override
        public float getInterpolation(float t) {
            return (float) (0.5f + Math.pow(t,3.0d));
        }
    }
}
