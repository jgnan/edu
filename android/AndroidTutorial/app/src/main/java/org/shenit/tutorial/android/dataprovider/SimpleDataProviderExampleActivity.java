package org.shenit.tutorial.android.dataprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.list.ArticleCursorAdapter;

public class SimpleDataProviderExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_data_provider_example);
        Cursor cursor = getContentResolver().query(Uri.parse("content://org.shenit.tutorial.android/articles"),
                null,null,null,null);
        ListView list = (ListView) findViewById(R.id.list_view);
        ArticleCursorAdapter adapter = new ArticleCursorAdapter(this,cursor);
        list.setAdapter(adapter);
    }
}
