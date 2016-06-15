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
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class GlideExampleActivity extends Activity {
    //预定义网络图片
    private static final String[] IMGS = {
            "http://www.wallpapersxl.com/wallpapers/1366x768/planes/102179/planes-crazy-rabbit-vote-hitchhiking-group-102179.jpg",
            "http://static.fjcdn.com/pictures/Crazy_1d08f1_613129.jpg",
            "http://www.walltor.com/images/wallpaper/wii-crazy-rabbit-60386.jpg",
            "http://g03.a.alicdn.com/kf/HTB1ROX7KVXXXXX2aXXXq6xXFXXX2/25CM-Kawaii-Crazy-Rabbit-Pokemon-Plush-Toys-Soft-Stuffed-Animals-minion-Plush-Bunny-Kids-Toys-New.jpg_640x640.jpg",
            "http://www.walltor.com/images/wallpaper/crazy-rabbit-60437.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView list = (ListView) findViewById(R.id.list_view);


        List<Movie> movies= new ArrayList<Movie>();
        //添加100条记录
        for(int i=0;i<100;i++) {
            String url = IMGS[ i % IMGS.length];    //轮流获取预定义网络图片
            movies.add(new Movie("Movie " + (i + 1),url));
        }
        for(String img : IMGS){
            Glide.with(getApplicationContext())
                    .load(img)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .preload();
        }

        list.setAdapter(new MovieAdapter(this,0,movies));
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
            Glide.with(getContext())
                    .load(item.cover)
                    .placeholder(R.mipmap.small)        //设置还没加载完成前显示的图片
                    .error(R.mipmap.small)              //当图片加载失败时显示的图片
                    .into(cover);
            title.setText(item.title);

            convertView.setTag(item);
            return convertView;
        }
    }

}
