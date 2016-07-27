package org.shenit.tutorial.android.fixscreen;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;

public class OrientationChangeExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //first load won't trigger the onConfigurationChanged, we need to get orientation by ourself
        onOrientationChanged(getResources().getConfiguration().orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        onOrientationChanged(newConfig.orientation);
    }

    private void onOrientationChanged(int orientation) {
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_orientation_change_example_land);
        }else {
            setContentView(R.layout.activity_orientation_change_example);
        }
    }
}
