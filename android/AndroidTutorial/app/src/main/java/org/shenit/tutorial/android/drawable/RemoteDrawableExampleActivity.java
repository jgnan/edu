package org.shenit.tutorial.android.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;

import org.shenit.tutorial.android.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDrawableExampleActivity extends AppCompatActivity {
    AppCompatImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_drawable_example);
        //load by async task directly.
        img1 = (AppCompatImageView) findViewById(R.id.img1);
        new LoadDrawableTask().execute();

    }


    class LoadDrawableTask extends AsyncTask<Void, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL url = new URL("http://www.wallpapersxl.com/wallpapers/1366x768/planes/102179/planes-crazy-rabbit-vote-hitchhiking-group-102179.jpg");
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
            img1.setImageBitmap(bm);
        }
    };

}
