package org.shenit.tutorial.android.dataproc;

import com.google.gson.annotations.Expose;

/**
 * Created by jiangnan on 5/26/16.
 */
public class Article {
    @Expose public String title;
    @Expose public String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
