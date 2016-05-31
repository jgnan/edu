package org.shenit.tutorial.android.list;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.shenit.tutorial.R;

public class CursorAdapterExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView list = (ListView) findViewById(R.id.list_view);
//        list.setAdapter(new ArticleCursorAdapter(this,R.layout.item_article,));
    }

    class ArticleCursorAdapter extends SimpleCursorAdapter{

        public ArticleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
        }

    }
}
