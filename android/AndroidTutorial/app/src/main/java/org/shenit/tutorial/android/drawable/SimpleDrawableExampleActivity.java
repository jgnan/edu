package org.shenit.tutorial.android.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.shenit.tutorial.android.R;

public class SimpleDrawableExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_example);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setImageDrawable(getDrawable(R.mipmap.middle));
        //TRY TO LOAD A LARGE FILE
        ImageView img3 = (ImageView) findViewById(R.id.img3);
        img3.setImageDrawable(getDrawable(R.mipmap.large));   //direct load, pretty slow and low efficient example


        //Optimize loading large image
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true; //set this to avoid loading the bitmap data to memory
        BitmapFactory.decodeResource(getResources(),R.mipmap.large,opts);
        int width = opts.outWidth;
        int height = opts.outHeight;


        opts.inJustDecodeBounds = false;
        opts.inSampleSize = 16;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.large,opts);
        img3.setImageBitmap(bitmap);

    }
}