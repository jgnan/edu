package org.shenit.tutorial.android;

import com.orm.SugarContext;

import org.shenit.tutorial.android.dataproc.ArticleSQLiteOpenHelper;

/**
 * 应用子类，利用这个类我们可以监听应用的生命周期并且定义一些应用级别的单例
 */
public class Application extends android.app.Application{
    //定义一个单例引用
    public static ArticleSQLiteOpenHelper articleSqlHelper;

    /**
     * 这个方法在应用初始化的时候被调用
     */
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
