package org.shenit.helloworld;

import com.orm.SugarContext;

/**
 * Created by jiangnan on 5/30/16.
 */
public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
