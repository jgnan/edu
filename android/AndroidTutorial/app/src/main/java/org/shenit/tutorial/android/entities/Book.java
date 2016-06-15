package org.shenit.tutorial.android.entities;

import java.util.Date;

/**
 * Created by jiangnan on 6/15/16.
 */
public class Book{
    public String title;
    public String author;
    public String content;
    public java.util.Date publishDate;

    public Book(String title, String author, Date publishDate,String content) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.content = content;
    }
}