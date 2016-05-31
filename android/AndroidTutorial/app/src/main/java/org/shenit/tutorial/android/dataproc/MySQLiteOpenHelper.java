package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jiangnan on 5/29/16.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "helloworld";
    //This number will affect whether called the onUpgrade method if it is higher than the last version in database
    private static final int DATABASE_VERSION = 1;
    private static final String ARTICLES_TABLE_NAME = "articles";
    private static final String ARTICLES_TABLE_CREATE =
            "CREATE TABLE " + ARTICLES_TABLE_NAME + " (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "TITLE TEXT NOT NULL, " +
                    "AUTHOR TEXT, " +
                    "CONTENT TEXT);";

    MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create article tables
        db.execSQL(ARTICLES_TABLE_CREATE);
        System.out.println("[onCreate] We run the onCreate method in MySQLiteOpenHelper!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing for its our first version
        System.out.println("[onCreate] We run the onUpgrade method in MySQLiteOpenHelper!!");
    }
}
