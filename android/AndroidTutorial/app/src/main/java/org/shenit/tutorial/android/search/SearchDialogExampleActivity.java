package org.shenit.tutorial.android.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.shenit.tutorial.android.R;

public class SearchDialogExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dialog_example);
        //注册搜索对话框的相关事件
        registerDialogEvents();
    }

    private void registerDialogEvents() {
        SearchManager searchMgr = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //当搜索对话框消失的时候会调用这个事件（包括取消和搜索执行）
        searchMgr.setOnDismissListener(new SearchManager.OnDismissListener() {
            @Override
            public void onDismiss() {
                Log.i("SearchDialogExample", "on dialog dismiss....");
            }
        });
        //当搜索对话框打开后被用户取消时才会调用这个事件
        searchMgr.setOnCancelListener(new SearchManager.OnCancelListener() {
            @Override
            public void onCancel() {
                Log.i("SearchDialogExample","on dialog canceled");
            }
        });
    }

    @Override
    public boolean onSearchRequested() {
        //我们可以通过重写这个方法来改变搜索的请求Bundle appData = new Bundle();
        Bundle data = new Bundle();
        //添加你的自定义数据
        startSearch(null, false, data, false);
        return true;
    }

    public void onSearch(View v){
        onSearchRequested();
    }
}
