package org.shenit.tutorial.android.media;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class MediaExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_examples);

        TutorialUtils.bind(this,R.id.local_media_player_example,LocalMediaExampleActivity.class);

    }
}
