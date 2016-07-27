package org.shenit.tutorial.android.serialization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class SerializationExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialization_examples);
        TutorialUtils.bind(this, R.id.serialization_example, SerializableFromActivity.class);
        TutorialUtils.bind(this, R.id.parcelable_example, ParcelableFromActivity.class);
    }
}
