package org.shenit.tutorial.android.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Article;

/**
 * Pull to refresh example.
 */
public class PullToRefreshExampleActivity extends AppCompatActivity {
    private int page = 1;
    private Handler handler = new Handler();
    private PullToRefreshListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_example);
        list = (PullToRefreshListView) findViewById(R.id.list_view);
        final ArticleListAdapter adapter = new ArticleListAdapter(this, Article.find(Article.class, null, null, null, null, "10"));
        list.setAdapter(adapter);
        list.setMode(PullToRefreshBase.Mode.BOTH);
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase) {
                page = 1;
                adapter.clear();
                adapter.addAll(Article.find(Article.class, null, null, null, null, "10"));
                adapter.notifyDataSetChanged(); //tell table data is updated
                Log.d("PullToRefresh", "Refresh complete!");
                handler.postDelayed(hideRefresh, 1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase) {
                adapter.addAll(Article.find(Article.class, null, null, null, null, (page++ * 10) + ",10"));
                adapter.notifyDataSetChanged(); //tell table data is updated
                Log.d("PullToRefresh", "Load complete!");
                handler.postDelayed(hideRefresh, 1000);
            }
        });
    }

    /**
     * This runnable will help us to terminate the refreshing label
     */
    private Runnable hideRefresh = new Runnable() {

        @Override
        public void run() {
            list.onRefreshComplete();
            if(list.isRefreshing()){
                handler.postDelayed(this,1000); //check every 1s if still refreshing
            }
        }
    };
}
