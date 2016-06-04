package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jiangnan on 5/29/16.
 */
public class ArticleSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String ARTICLES_TABLE_NAME = "articles";

    private static final String DATABASE_NAME = "helloworld.db";
    //This number will affect whether called the onUpgrade method if it is higher than the last version in database
    private static final int DATABASE_VERSION = 1;

    //SQLITE is case sensitive, so keep use column in lower snake case will be helpful in your coding
    private static final String ARTICLES_TABLE_CREATE =
            "CREATE TABLE " + ARTICLES_TABLE_NAME + " (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "TITLE TEXT NOT NULL, " +
                    "AUTHOR TEXT, " +
                    "CONTENT TEXT);";

    public ArticleSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create article tables
        db.execSQL(ARTICLES_TABLE_CREATE);
        System.out.println("[onCreate] We run the onCreate method in ArticleSQLiteOpenHelper!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing for its our first version
        System.out.println("[onCreate] We run the onUpgrade method in ArticleSQLiteOpenHelper!!");
    }

    /**
     * List all articles
     * @return
     */
    public Cursor listArticles() {
        return getReadableDatabase()
                .rawQuery("select ID as _id, title, author,content from articles order by ID desc", null);
    }

    /**
     * Get a single article record by id
     * @param id
     * @return
     */
    public Cursor findArticleById(String id) {
        return getReadableDatabase()
                .rawQuery("select ID as _id, title, author,content from articles where id = ?",
                        new String[]{id});
    }
}
