package org.shenit.tutorial.android.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Book的Parcelable实现
 * Created by 江老师 on 6/15/16.
 */
public class ParcelableBook implements Parcelable{
    public String title;
    public String author;
    public String content;
    public Date publishDate;

    public ParcelableBook(){}

    public ParcelableBook(String title, String author, Date publishDate, String content) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.content = content;
    }

    /**
     * Parcelable实例需要提供一个Creator实例来辅助进行序列化和反序列化的过程
     */
    public static final Creator<ParcelableBook> CREATOR = new Creator<ParcelableBook>() {
        @Override
        public ParcelableBook createFromParcel(Parcel in) {
            ParcelableBook book = new ParcelableBook();
            //这里会按照序列化的顺序逐个获取Parcel里面的东西
            book.title = in.readString();
            book.author = in.readString();
            book.publishDate = new Date(in.readLong());
            book.content = in.readString();
            //反序列化的过程
            return book;
        }

        @Override
        public ParcelableBook[] newArray(int size) {
            //假如要反序列化成一个数组，这会先调用这个方法创建目标数组类，再循环调用createFromParcel方法
            return new ParcelableBook[size];
        }
    };

    @Override
    public int describeContents() {
        //这个方法返回一个二进制掩码，告诉系统这个Parcelable类包含了什么特殊的对象类型，默认无视就好
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //当我们要进行序列化的时候调用的方法，把这个实例的东西写进去Parcel实例传递给目标环境
        dest.writeString(title);
        dest.writeString(author);
        dest.writeLong(publishDate == null ? null : publishDate.getTime()); //无法直接传递对象(除了基础类型外）
        dest.writeString(content);
    }
}