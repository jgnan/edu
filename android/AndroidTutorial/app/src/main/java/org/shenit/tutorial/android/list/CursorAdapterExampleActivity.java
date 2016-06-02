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
import android.widget.TextView;
import android.widget.Toast;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;
import org.shenit.tutorial.android.entities.Article;

public class CursorAdapterExampleActivity extends AppCompatActivity{
    ArticleSQLiteOpenHelper sqlHelper = null;
    //If you want to use cursor adapter, you must contain a "_id" field, or the class will not work!
    public static final String[] ARTICLES_TABLE_LIST_COLUMNS = new String[]{"_id","title","author"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView list = (ListView) findViewById(R.id.list_view);
        sqlHelper = new ArticleSQLiteOpenHelper(this);

//        Cursor cursor = sqlHelper.getReadableDatabase().query(ArticleSQLiteOpenHelper.ARTICLES_TABLE_NAME,
//                ArticleSQLiteOpenHelper.ARTICLES_TABLE_LIST_COLUMNS,
//                null,null,null,null,null,null);
        list.setAdapter(new ArticleCursorAdapter(this,R.layout.item_article,
                sqlHelper.queryArticlesForAdapter(),
                ARTICLES_TABLE_LIST_COLUMNS,
                new int[]{R.id.title,R.id.author}, 0));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article art = (Article)view.getTag();
                Toast.makeText(CursorAdapterExampleActivity.this,"Id is -> "+art.getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ArticleCursorAdapter extends SimpleCursorAdapter {

        @Override
        public int getCount() {
            return super.getCount();
        }

        public ArticleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
        }

        /*
         * Override this method to generate new view according to cursor and context
         */
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            super.bindView(view,context,cursor);
            Article art = new Article();
            art.setId(cursor.getLong(cursor.getColumnIndex("_id")));
            art.title = cursor.getString(cursor.getColumnIndex("title"));
            art.author= cursor.getString(cursor.getColumnIndex("author"));

            view.setTag(art);
        }

        /*
         * Override this method to implement your view loading logic
         */
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return super.newView(context, cursor, parent);
        }
    }
}
