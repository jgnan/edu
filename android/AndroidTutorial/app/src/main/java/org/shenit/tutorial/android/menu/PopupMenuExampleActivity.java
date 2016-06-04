package org.shenit.tutorial.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

/**
 * Popup menu example.
 */
public class PopupMenuExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_example);
    }

    public void onShowPopup(View v){
        PopupMenu popup = new PopupMenu(this,v, Gravity.BOTTOM);
        popup.inflate(R.menu.menu_example);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(PopupMenuExampleActivity.this,"You click the \""+item.getTitle()+"\" menu",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }
}
