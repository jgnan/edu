package org.shenit.tutorial.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.Utils;

public class MenuExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_examples);
        Utils.bind(this, R.id.top_menu_example, TopMenuExampleActivity.class);
        Utils.bind(this,R.id.context_menu_example,ContextMenuExampleActivity.class);
    }
}
