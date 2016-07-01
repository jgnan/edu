package org.shenit.tutorial.android.search;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import org.shenit.tutorial.android.Application;

/**
 * 自定义搜索建议项示例
 */
public class ArticleSearchSuggestionsProvider extends ContentProvider{
    public static final String AUTHORITY = "org.shenit.tutorial.android.search.ArticleSearchSuggestionsProvider";
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int CODE_QUERY = 1;

    static{
        MATCHER.addURI(AUTHORITY,SearchManager.SUGGEST_URI_PATH_QUERY+"/*",CODE_QUERY);
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch(MATCHER.match(uri)){
            case CODE_QUERY:
                return Application.articleSqlHelper.searchArticles(uri.getLastPathSegment());
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
