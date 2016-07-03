package org.shenit.tutorial.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.shenit.tutorial.android.Application;
import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.list.ArticleCursorAdapter;

/**
 * This example show you how to create context menu, like right click popup menu.
 */
public class ContextMenuExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_example);
        registerForContextMenu(findViewById(R.id.button_more));
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(new ArticleCursorAdapter(this, Application.articleSqlHelper.listArticles()));
        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (menuInfo instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            System.out.println(">>>>> pos -> " + acmi.position);      //This will indicate the real item id selected
        }else{

        }
        getMenuInflater().inflate(R.menu.menu_example, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
