package org.shenit.tutorial.android.search;

import android.content.SearchRecentSuggestionsProvider;

/**
 * 近期搜索建议项的ContentProvider.
 */
public class RecentSearchContentProvider extends SearchRecentSuggestionsProvider{
    public final static String AUTHORITY = "org.shenit.tutorial.android.search.RecentSearchProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public RecentSearchContentProvider() {
        //设置搜索建议的权限域和数据库工作模式
        setupSuggestions(AUTHORITY, MODE);
    }
}
