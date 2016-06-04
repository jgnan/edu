package org.shenit.tutorial.android;

import com.orm.SugarContext;

import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;

/**
 * Created by jiangnan on 5/30/16.
 */
public class Application extends android.app.Application{
    public static ArticleSQLiteOpenHelper articleSqlHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        articleSqlHelper = new ArticleSQLiteOpenHelper(this);
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
