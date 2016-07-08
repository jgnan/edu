package org.shenit.tutorial.android.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentService 使用示例.这个Service会自动把请求Intent保存到一个队列中，然后逐个处理.
 */
public class IntentServiceExample extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public IntentServiceExample() {
        super(IntentServiceExample.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String msg =intent.getStringExtra("message");
        Log.d("IntentServiceExample",msg);
    }
}
