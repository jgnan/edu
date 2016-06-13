package org.shenit.tutorial.android.dataprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;

/**
 * Created by 江老师 on 5/30/16.
 */
public class ArticlesDataProvider extends ContentProvider {
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int URI_CODE_ALL_RECORDS = 1;
    private static final int URI_CODE_SINGLE_RECORD = 2;
    private static final int URI_CODE_RECORD_SET = 3;
    public static final String[] COLUMNS = {"id","title","author","content"};
    static{
        URI_MATCHER.addURI("org.shenit.tutorial.android","articles",URI_CODE_ALL_RECORDS);
        URI_MATCHER.addURI("org.shenit.tutorial.android","articles/*",URI_CODE_RECORD_SET);
        URI_MATCHER.addURI("org.shenit.tutorial.android","articles/#",URI_CODE_SINGLE_RECORD);
    }


    private ArticleSQLiteOpenHelper sqliteHelper;
    @Override
    public boolean onCreate() {
        sqliteHelper = new ArticleSQLiteOpenHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch(URI_MATCHER.match(uri)){
            //content://org.shenit.tutorial.android/articles
            case URI_CODE_ALL_RECORDS:
                return sqliteHelper.listArticles();
            //content://org.shenit.tutorial.android/articles/1
            case URI_CODE_SINGLE_RECORD:
                return sqliteHelper.findArticleById(uri.getLastPathSegment());
            //content://org.shenit.tutorial.android/articles/lastest
            case URI_CODE_RECORD_SET:
                //TODO another switch case segment for record set handling
                return sqliteHelper.listArticles();
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
