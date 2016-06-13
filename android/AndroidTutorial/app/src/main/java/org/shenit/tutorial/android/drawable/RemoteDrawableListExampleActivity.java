package org.shenit.tutorial.android.drawable;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RemoteDrawableListExampleActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView list = (ListView) findViewById(R.id.list_view);


        List<Movie> movies= new ArrayList<Movie>();
        //添加100条记录
        for(int i=0;i<100;i++) {
            movies.add(new Movie("Movie "+(i +1),
                    "http://www.wallpapersxl.com/wallpapers/1366x768/planes/102179/planes-crazy-rabbit-vote-hitchhiking-group-102179.jpg"));
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
            new RemoteDrawableTask(cover).execute(item.cover);
            title.setText(item.title);

            convertView.setTag(item);
            return convertView;
        }
    }


    class RemoteDrawableTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        RemoteDrawableTask(ImageView imageView) {
            this.imageViewReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                InputStream is = url.openStream();
                return  BitmapFactory.decodeStream(is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bm) {
            if(bm != null && imageViewReference.get()!= null) imageViewReference.get().setImageBitmap(bm);
        }
    };
}
