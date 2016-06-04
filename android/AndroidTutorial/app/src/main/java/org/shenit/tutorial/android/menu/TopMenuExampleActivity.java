package org.shenit.tutorial.android.menu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

/**
 * This example shows you how to create a simple action bar menu.
 */
public class TopMenuExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu_example);
    }

    /**
     * Override this method to create action on your actionbar(if exists)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Override this method to implement action kickoff when use click an option.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_new:
                Toast.makeText(this,"You click the New item in action bar!!",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
