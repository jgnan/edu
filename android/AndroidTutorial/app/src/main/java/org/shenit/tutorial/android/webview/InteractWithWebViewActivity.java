package org.shenit.tutorial.android.webview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import org.shenit.tutorial.android.R;

public class InteractWithWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact_with_web_view);
        WebView webview = (WebView) findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new WebInterface(this),"App");

        webview.loadUrl("file:///android_res/raw/interact.html");
    }

    /**
     * Create an interface to work with web's javascript
     */
    class WebInterface {
        Context mContext;
        WebInterface(Context c){
            this.mContext = c;
        }

        /**
         * Mark this to expose your method to javascript engine
         * @param toast
         */
        @JavascriptInterface
        public void showToast(String toast){
            Toast.makeText(mContext,toast,Toast.LENGTH_LONG).show();
        }
    }

}
