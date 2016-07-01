package org.shenit.tutorial.android.list;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Article;

/**
 * CursorAdapter的示例代码.
 */
public class ArticleCursorAdapter extends SimpleCursorAdapter {
    //If you want to use cursor adapter, you must contain a "_id" field, or the class will not work!
    public static final String[] ARTICLES_TABLE_LIST_COLUMNS = new String[]{"TITLE","AUTHOR"};
    private static final int[] ARTICLE_VIEW_IDS = new int[]{R.id.title,R.id.author};

    public ArticleCursorAdapter(Context context,  Cursor c) {
        super(context, R.layout.item_article, c, ARTICLES_TABLE_LIST_COLUMNS,ARTICLE_VIEW_IDS, 0);
    }

    /*
     * Override this method to generate new view according to cursor and context
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        Article art = new Article();
        art.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        art.title = cursor.getString(cursor.getColumnIndex("TITLE"));
        art.author= cursor.getString(cursor.getColumnIndex("AUTHOR"));

        view.setTag(art);
    }
}