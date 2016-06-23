package org.shenit.tutorial.android.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
    private ArticleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_example);
        list = (PullToRefreshListView) findViewById(R.id.list_view);
        adapter = new ArticleListAdapter(this, Article.find(Article.class, null, null, null, null, "10"));
        list.setAdapter(adapter);
        list.setMode(PullToRefreshBase.Mode.BOTH);
        list.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                Log.d("PullToRefresh","LAST ITEM VIEWED!");
            }
        });
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase) {
                //重新加载页面数据，从第一页开始
                Log.d("PullToRefresh", "Refresh complete!");
                page = 1;
                adapter.clear();
                adapter.addAll(Article.find(Article.class, null, null, null, null, "10"));
                handler.post(updateRunner);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase) {
                Log.d("PullToRefresh", "Load complete!");
                //加载当前最后一页开始的后10条数据
                adapter.addAll(Article.find(Article.class, null, null, null, null, (page++ * 10) + ",10"));
                handler.post(updateRunner);
            }
        });
    }

    /**
     * 更新UI
     */
    private Runnable updateRunner = new Runnable() {

        @Override
        public void run() {
            list.onRefreshComplete();
            updateMode();
            adapter.notifyDataSetChanged(); //tell table data is updated
        }
    };

    /**
     * 更新列表刷新模式.
     */
    private void updateMode(){
        long count = Article.count(Article.class);
        if(adapter.getCount() >= count) {
            list.setMode(PullToRefreshBase.Mode.PULL_FROM_START);   //已经没有更多记录，只能下拉刷新
        }else {
            list.setMode(PullToRefreshBase.Mode.BOTH);   //重新启用下拉加载更多功能
        }
    }

}
