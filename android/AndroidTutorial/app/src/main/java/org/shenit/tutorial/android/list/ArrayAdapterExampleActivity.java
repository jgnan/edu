package org.shenit.tutorial.android.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.shenit.tutorial.android.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayAdapterExampleActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView list = (ListView) findViewById(R.id.list_view);

        List<Book> books = new ArrayList<Book>();
        //添加100条记录
        for(int i=0;i<100;i++) {
            books.add(new Book("Book title " + (i + 1),
                    "author " + (i + 1),
                    new Date(),
                    "Long long content for book " + (i + 1)));
        }

        list.setAdapter(new BookAdapter(this,0,books));

        //设置鼠标点击单条记录时的处理事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转页面代码
                Intent intent = new Intent(ArrayAdapterExampleActivity.this,BookDetailActivity.class);
                Bundle bundle = new Bundle();
                Book book = (Book) view.getTag();
                bundle.putString("title",book.title);
                bundle.putString("author",book.author);
                bundle.putString("content",book.content);
                bundle.putLong("publish",book.publishDate.getTime());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private class Book{
        String title;
        String author;
        String content;
        java.util.Date publishDate;

        public Book(String title, String author, Date publishDate,String content) {
            this.title = title;
            this.author = author;
            this.publishDate = publishDate;
            this.content = content;
        }
    }

    private class BookAdapter extends ArrayAdapter<Book>{

        public BookAdapter(Context context, int resource, List<Book> objects) {
            super(context, resource,  objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            System.out.println("pos -> "+position+", convertView -> "+convertView);
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_book,null);
            }

            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView author = (TextView) convertView.findViewById(R.id.author);
            Book item = getItem(position);
            title.setText(item.title);
            author.setText(item.author);

            convertView.setTag(item);
            return convertView;
        }
    }

}
