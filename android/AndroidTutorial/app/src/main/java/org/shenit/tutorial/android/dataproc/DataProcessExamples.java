package org.shenit.tutorial.android.dataproc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.R;

import static org.shenit.tutorial.android.Utils.bind;

public class DataProcessExamples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_process_examples);
        bind(this, R.id.json_process_example, JsonProcessExample.class);
        bind(this,R.id.shared_preferences_storage_example,SharedPreferencesExampleActivity.class);
        bind(this,R.id.internal_file_storage_example,InternalStorageExampleActivity.class);
        bind(this,R.id.external_file_storage_example,ExternalStorageExampleActivity.class);
        bind(this,R.id.sqlite_storage_example,SQLiteStorageExampleActivity.class);
    }
}
