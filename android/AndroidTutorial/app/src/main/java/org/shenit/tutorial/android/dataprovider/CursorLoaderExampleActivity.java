package org.shenit.tutorial.android.dataprovider;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.list.ArticleCursorAdapter;

public class CursorLoaderExampleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    ListView list;
    ArticleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list = (ListView) findViewById(R.id.list_view);
        adapter = new ArticleCursorAdapter(this,null);
        list.setAdapter(adapter);
        getLoaderManager().initLoader(1,null,this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, Uri.parse("content://org.shenit.tutorial.android/articles"),null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader loader, Cursor data) {
        adapter.changeCursor(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        loader.forceLoad();
    }
}
