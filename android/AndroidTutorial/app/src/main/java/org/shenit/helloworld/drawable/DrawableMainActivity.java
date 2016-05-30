package org.shenit.helloworld.drawable;

import static org.shenit.helloworld.Utils.bind;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.helloworld.R;

public class DrawableMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_main);

        bind(this,R.id.remote_drawable_example_link, RemoteDrawableExampleActivity.class);
        bind(this,R.id.drawable_example_link, SimpleDrawableExampleActivity.class);
        bind(this,R.id.other_drawable_example_link,OtherDrawableExampleActivity.class);
        bind(this,R.id.remote_drawable_list_example_link, RemoteDrawableListExampleActivity.class);
        bind(this,R.id.shape_drawable_example_link, ShapeDrawableExampleActivity.class);
        bind(this,R.id.glide_example_link, GlideExampleActivity.class);
    }
}
