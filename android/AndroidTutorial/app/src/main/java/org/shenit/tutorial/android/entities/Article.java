package org.shenit.tutorial.android.entities;

import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by 江老师 on 5/30/16.
 */
@Table(name="articles")
public class Article extends SugarRecord{
    @Expose public String title;
    @Expose public String author;
    @Expose public String content;

    public Article(){}
    public Article(String title, String content){
        this(title,null,content);
    }
    public Article(String title, String author,String content){
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
