package org.shenit.tutorial.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.shenit.tutorial.android.Application;
import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;
import org.shenit.tutorial.android.list.ArticleCursorAdapter;

/**
 * This example show you how to create context menu, like right click popup menu.
 */
public class ContextMenuExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_view);
//        ListView list = (ListView) findViewById(R.id.list_view);
//        list.setAdapter(new ArticleCursorAdapter(this, Application.articleSqlHelper.listArticles()));
//        registerForContextMenu(list);
        setContentView(R.layout.activity_context_menu_example);
        registerForContextMenu(findViewById(R.id.button_more));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_example,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
