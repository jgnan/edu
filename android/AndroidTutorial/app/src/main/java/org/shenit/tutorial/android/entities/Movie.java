package org.shenit.tutorial.android.entities;

/**
 * Created by 江老师 on 6/13/16.
 */
public class Movie {
    //视频封面图，是一个HTTP的URL
    public String cover;
    //视频标题
    public String title;

    public Movie(String title, String cover) {
        this.title = title;
        this.cover = cover;
    }
}
