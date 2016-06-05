package org.shenit.tutorial.android.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.fragment.SimpleImageFragment;

/**
 * This example shows the basic use of view pager
 */
public class ViewPagerExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_example);
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Log.d("ViewPagerExample",">>>>> Creating new Fragment for position -> "+position);
                return new SimpleImageFragment();
            }

            @Override
            public int getCount() {
                return 30;
            }
        });
    }
}
