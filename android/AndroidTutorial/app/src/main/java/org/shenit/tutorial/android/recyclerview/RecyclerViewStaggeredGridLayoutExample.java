package org.shenit.tutorial.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import org.shenit.tutorial.android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewStaggeredGridLayoutExample extends AppCompatActivity {
    RecyclerView recyclerView;
    ComplexRecyclerAdapter adapter;
    private static final String[] RABBIT_THUMBNAILS = {"http://s.tkec.com.tw/image/product/desc/200901/0%28101%29.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1011674648,488055205&fm=21&gp=0.jpg",
            "http://img.131.com/www/2010/07/13/20100713102125ddb.jpg",
            "http://dl.bizhi.sogou.com/images/2012/09/23/41175.jpg",
            "http://image.thermaltake.com/News/db/imgs/press/images/TTFUN/20140212/1/%E5%9C%96%E5%83%8F00002.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter = new ComplexRecyclerAdapter(null);
        //preload our images
        RequestManager reqMgr = Glide.with(this);
        for(String url : RABBIT_THUMBNAILS) reqMgr.load(url).preload(100,100);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Map<String,String>> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            HashMap<String,String> row = new HashMap<String,String>();
            row.put("thumbnail", RABBIT_THUMBNAILS[i % RABBIT_THUMBNAILS.length]);
            row.put("title","Rabbit Image "+ i);
            data.add(row);
        }
        adapter.addAll(data);
        adapter.notifyDataSetChanged();

    }
}
