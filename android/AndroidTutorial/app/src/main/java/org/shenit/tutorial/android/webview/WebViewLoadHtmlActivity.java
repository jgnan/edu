package org.shenit.tutorial.android.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import org.shenit.tutorial.android.R;

public class WebViewLoadHtmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_load_html);

        final WebView webview = (WebView) findViewById(R.id.webview);
        String html = "<h1>Hello world!!</h1>";
        final EditText htmlEditor = (EditText) findViewById(R.id.htmlEditor);
        htmlEditor.setText(html);
        htmlEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                webview.loadData(htmlEditor.getText().toString(),"text/html","utf-8");
            }
        });

        webview.loadData("<h1>Hello world!!</h1>","text/html","utf-8");
    }
}
