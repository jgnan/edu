package org.shenit.tutorial.android.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Article;
import org.shenit.tutorial.android.list.ArticleListAdapter;

import java.util.List;

public class ArticleSearchActivity extends AppCompatActivity {
    ArticleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(Intent.ACTION_SEARCH == intent.getAction()) {
            doSearch(intent);
        }else if(Intent.ACTION_VIEW == intent.getAction()){
            showResults(intent);
        }
    }

    /**
     * 处理自定义搜索选项的请求
     * @param intent
     * @return
     */
    private void showResults(Intent intent) {
        setContentView(R.layout.activity_search_result);
        //获取android:searchSuggestIntentData + SearchMangager.SUGGEST_COLUMN_INTENT_DATA_ID构成的DATA URI
        Uri data = intent.getData();
        String query = data.getLastPathSegment();   //如果有映射SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID，则为此字段的值
        Article article = Article.findById(Article.class, Long.parseLong(query));
        TextView titleText = (TextView) findViewById(R.id.title);
        TextView authorText = (TextView) findViewById(R.id.author);
        titleText.setText(article.title);
        authorText.setText(article.author);
    }

    /**
     * 处理搜索请求
     * @return
     */
    private void doSearch(Intent intent) {
        setContentView(R.layout.activity_article_search);
        ListView listView = (ListView) findViewById(android.R.id.list);
        List<Article> articles = null;
        String query = intent.getStringExtra(SearchManager.QUERY);  //用户输入的搜索关键字
        Bundle data = intent.getBundleExtra(SearchManager.APP_DATA);    //传递给startSearch的appData数据

        //保存搜索项作为搜索建议
        SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                RecentSearchContentProvider.AUTHORITY, RecentSearchContentProvider.MODE);
        suggestions.saveRecentQuery(query, null);   //如果你的模式使用了DATABASE_MODE_LINE2，则需要提供第二个参数的值

        articles =  Article.find(Article.class,"TITLE LIKE ? OR AUTHOR LIKE ?",new String[]{query+"%",query+"%"},null,"id desc",null);
        if(adapter == null) {
            adapter = new ArticleListAdapter(this,articles);
            listView.setAdapter(adapter);
        }else {
            adapter.clear();
            adapter.addAll(articles);
            adapter.notifyDataSetChanged();
        }

    }


    @Override
    protected void onNewIntent(Intent intent) {
        if(Intent.ACTION_SEARCH == intent.getAction()){
            doSearch(intent);
        }else if(Intent.ACTION_VIEW == intent.getAction()){
            showResults(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        SearchManager mgr = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(mgr.getSearchableInfo(getComponentName()));
        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(menu);
    }
}
