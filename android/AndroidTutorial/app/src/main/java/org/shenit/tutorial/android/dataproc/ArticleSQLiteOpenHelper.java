package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLiteOpenHelper示例
 */
public class ArticleSQLiteOpenHelper extends SQLiteOpenHelper {
    //文章数据表名
    public static final String ARTICLES_TABLE_NAME = "articles";
    //数据库文件名
    private static final String DATABASE_NAME = "helloworld.db";
    //数据库版本名，如果构建这个类的时候的版本号比文件的版本号要大，这回执行OnUpgrade方法
    private static final int DATABASE_VERSION = 1;

    //注意SQLite是大小写敏感的，所以一般字段名都用大写
    private static final String ARTICLES_TABLE_CREATE =
            "CREATE TABLE " + ARTICLES_TABLE_NAME + " (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "TITLE TEXT NOT NULL, " +
                    "AUTHOR TEXT, " +
                    "CONTENT TEXT);";

    /**
     * 构造函数，注意这里传递了DATABASE_NAME和DATABASE_VERSION参数
     * @param context
     */
    public ArticleSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 如果应用尝试调用数据库连接实例进行执行代码，系统会检测是否已经创建数据库，如果没有会自动调用这个方法进行创建.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create article tables
        db.execSQL(ARTICLES_TABLE_CREATE);
        System.out.println("[onCreate] We run the onCreate method in ArticleSQLiteOpenHelper!!");
    }

    /**
     * 如前所述，如果构造函数传递的DATABASE_VERSION比DATABASE_NAME指向的文件的版本大，会自动执行这个脚本让你实现升级的代码
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing for its our first version
        db.execSQL("DROP TABLE "+ARTICLES_TABLE_NAME);
        onCreate(db);
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
     * List all articles
     * @return
     */
    public Cursor listArticles(int page,int size) {
        int startIndex = Math.max(0, (page - 1) * size);
        return getReadableDatabase()
                .rawQuery("select ID as _id, title, author,content from articles order by ID desc limit ? offset ?",
                        new String[]{String.valueOf(size),String.valueOf(startIndex)});
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
