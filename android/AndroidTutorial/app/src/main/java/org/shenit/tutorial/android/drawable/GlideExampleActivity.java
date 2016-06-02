package org.shenit.tutorial.android.drawable;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.shenit.tutorial.android.R;

import java.util.ArrayList;
import java.util.List;

public class GlideExampleActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView list = (ListView) findViewById(R.id.list_view);


        List<Movie> movies= new ArrayList<Movie>();
        //添加100条记录
        for(int i=0;i<100;i++) {
            String url = "http://www.wallpapersxl.com/wallpapers/1366x768/planes/102179/planes-crazy-rabbit-vote-hitchhiking-group-102179.jpg";
            movies.add(new Movie("Movie " + (i + 1), url));
            Glide.with(this).load(url).preload();
        }

        list.setAdapter(new MovieAdapter(this,0,movies));
    }

    private class Movie {
        String cover;
        String title;

        public Movie(String title, String cover) {
            this.title = title;
            this.cover = cover;
        }
    }

    private class MovieAdapter extends ArrayAdapter<Movie>{

        public MovieAdapter(Context context, int resource, List<Movie> objects) {
            super(context, resource,  objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_movie,null);
            }

            ImageView cover= (ImageView) convertView.findViewById(R.id.cover);
            TextView title= (TextView) convertView.findViewById(R.id.title);
            Movie item = getItem(position);
            Glide.with(getContext()).load(item.cover).into(cover);
            title.setText(item.title);

            convertView.setTag(item);
            return convertView;
        }
    }

}
