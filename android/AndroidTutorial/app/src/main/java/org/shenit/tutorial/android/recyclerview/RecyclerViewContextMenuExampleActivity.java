package org.shenit.tutorial.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;

import com.bumptech.glide.Glide;

import org.shenit.tutorial.android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewContextMenuExampleActivity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this));       //set a layout manager
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycler.setAdapter(new ComplexRecyclerAdapter(initData()));    //set a RecyclerView.Adapter
        registerForContextMenu(recycler);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_example, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private List<Map<String, String>> initData() {
        List<Map<String,String>> data = new ArrayList<>();
        for( int i =0;i<100;i++){
            HashMap<String,String> row = new HashMap<>();
            row.put("thumbnail", "http://img.dwstatic.com/tv/1402/256216992074/256217381102.jpg");
            Glide.with(this).load(row.get("thumbnail")).preload();
            row.put("title", "Contact Data");
            data.add(row);
        }
        return data;
    }
}
