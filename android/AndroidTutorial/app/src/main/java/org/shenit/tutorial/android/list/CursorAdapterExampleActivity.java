package org.shenit.tutorial.android.list;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.shenit.tutorial.android.Application;
import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;
import org.shenit.tutorial.android.entities.Article;

public class CursorAdapterExampleActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView list = (ListView) findViewById(R.id.list_view);

//        Cursor cursor = sqlHelper.getReadableDatabase().query(ArticleSQLiteOpenHelper.ARTICLES_TABLE_NAME,
//                ArticleSQLiteOpenHelper.ARTICLES_TABLE_LIST_COLUMNS,
//                null,null,null,null,null,null);
        list.setAdapter(new ArticleCursorAdapter(this, Application.articleSqlHelper.listArticles()));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article art = (Article)view.getTag();
                Toast.makeText(CursorAdapterExampleActivity.this,"Id is -> "+art.getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
