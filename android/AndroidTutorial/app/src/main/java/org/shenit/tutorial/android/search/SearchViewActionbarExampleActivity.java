package org.shenit.tutorial.android.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.SearchView;

import org.shenit.tutorial.android.R;

public class SearchViewActionbarExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar_search_view_example);
        SearchView searchView = (SearchView) findViewById(R.id.search);
        loadSearchInfo(searchView);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryRefinementEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 加载菜单项
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        loadSearchInfo(searchView);

        return true;
    }

    private void loadSearchInfo(SearchView searchView) {
        // 获取搜索用的ACTION VIEW
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        // 假设当前的活动是可搜索的活动
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // 默认展开视图
    }
}
