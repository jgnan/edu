package org.shenit.tutorial.android.fragment;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.shenit.tutorial.android.R;

public class LifeCycleExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_cycle_example);
        Log.d("ALifeCycle","***** onCreate event...");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALifeCycle", "***** onStop event...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALifeCycle", "***** onDestroy event...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALifeCycle", "***** onPause event...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALifeCycle", "***** onResume event...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALifeCycle", "***** onStart event...");
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Log.d("ALifeCycle","***** onCreateView event...");
        return super.onCreateView(parent, name, context, attrs);
    }



    public void onAddFragment(View v){
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.fragment_section, new LifeCycleExampleFragment());
        trans.commit();
    }

    public void onRemoveFragment(View v){
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragment_section, new SimpleTextFragment());
        trans.commit();
    }

}
