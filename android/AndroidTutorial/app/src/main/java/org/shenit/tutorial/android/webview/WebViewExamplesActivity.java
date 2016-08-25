package org.shenit.tutorial.android.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;

public class WebViewExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_examples);
        TutorialUtils.bind(this,R.id.simple_webview_example_button,SimpleWebViewExampleActivity.class);
        TutorialUtils.bind(this,R.id.load_html_example_button,WebViewLoadHtmlActivity.class);
        TutorialUtils.bind(this,R.id.interact_with_web_button,InteractWithWebViewActivity.class);
    }
}
