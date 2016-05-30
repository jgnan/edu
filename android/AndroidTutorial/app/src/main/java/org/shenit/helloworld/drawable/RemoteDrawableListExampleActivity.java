package org.shenit.helloworld.drawable;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.shenit.helloworld.R;

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
            cover.setImageDrawable(new AsyncDrawable(getResources(),
                    ((BitmapDrawable) cover.getDrawable()).getBitmap(),
                    new RemoteDrawableTask(cover)));
            title.setText(item.title);

            convertView.setTag(item);
            return convertView;
        }
    }


    public class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<RemoteDrawableTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources res, Bitmap bitmap,
                             RemoteDrawableTask bitmapWorkerTask) {
            super(res, bitmap);
            bitmapWorkerTaskReference =
                    new WeakReference<RemoteDrawableTask>(bitmapWorkerTask);
            bitmapWorkerTask.execute();
        }

        public RemoteDrawableTask getBitmapWorkerTask() {
            return bitmapWorkerTaskReference.get();
        }
    }


    class RemoteDrawableTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        RemoteDrawableTask(ImageView imageView) {
            this.imageViewReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL url = new URL("http://2fun2fun.com/wp-content/uploads/2014/05/5.6-52.jpg");
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
