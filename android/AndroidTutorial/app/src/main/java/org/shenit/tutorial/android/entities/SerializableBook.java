package org.shenit.tutorial.android.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Book的Serializable实现
 * Created by 江老师 on 6/15/16.
 */
public class SerializableBook implements Serializable{
    public String title;
    public String author;
    public String content;
    public Date publishDate;

    public SerializableBook(String title, String author, Date publishDate, String content) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.content = content;
    }
}