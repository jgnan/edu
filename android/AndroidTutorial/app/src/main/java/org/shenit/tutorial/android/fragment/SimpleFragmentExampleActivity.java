package org.shenit.tutorial.android.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.shenit.tutorial.android.R;

/**
 *
 */
public class SimpleFragmentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framgment_usage_example);
        //Dynamic adding fragment
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.add_fragment_example, new SimpleTextFragment());
        trans.add(R.id.add_fragment_example, new SimpleTextFragment());
        trans.add(R.id.add_fragment_example, new SimpleTextFragment());
        trans.replace(R.id.replace_fragment_example,new SimpleTextFragment());
        trans.commit();
    }

    public void onChangeFragment(View v){
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.add_fragment_example, new SimpleImageFragment());
        trans.commit();
    }
}
