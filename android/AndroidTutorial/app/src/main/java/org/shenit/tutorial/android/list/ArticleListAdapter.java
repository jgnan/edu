package org.shenit.tutorial.android.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Article;

import java.util.List;

/**
 * Created by 江老师 on 6/2/16.
 */
public class ArticleListAdapter extends ArrayAdapter<Article> {
    private LayoutInflater mInflater;


    public ArticleListAdapter(Context context, List<Article> article) {
        super(context, R.layout.item_article, article);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = mInflater.inflate(R.layout.item_book,null);
        Article art = getItem(position);

        ((TextView)convertView.findViewById(R.id.title)).setText(art.title);
        ((TextView)convertView.findViewById(R.id.author)).setText(art.author);
        convertView.setTag(art);
        return convertView;
    }



}