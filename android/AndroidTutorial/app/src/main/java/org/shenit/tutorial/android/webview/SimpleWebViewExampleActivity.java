package org.shenit.tutorial.android.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import org.shenit.tutorial.android.R;

public class SimpleWebViewExampleActivity extends AppCompatActivity {
    private EditText mUrlText;
    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_view_example);
        mWebview = (WebView) findViewById(R.id.webview);

        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient());  //内嵌页面必备

        mWebview.loadUrl("http://www.baidu.com");

        mUrlText = (EditText) findViewById(R.id.url);
        mUrlText.setText("http://www.baidu.com");
    }

    public void onGoClick(View v){
        mWebview.loadUrl(mUrlText.getText().toString());
    }


}