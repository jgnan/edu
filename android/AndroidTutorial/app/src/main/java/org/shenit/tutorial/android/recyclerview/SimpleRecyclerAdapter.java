package org.shenit.tutorial.android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.shenit.tutorial.android.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangnan on 6/5/16.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>{
    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_CONTACT = 2;
    private List<Map<String,String> > data = new ArrayList<>();

    public SimpleRecyclerAdapter(List<Map<String, String>> data){
        if(data != null) this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_thumbnail,null));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<String,String> row = data.get(position);
        ViewHolder contactHolder = (ViewHolder) holder;
        Glide.with(holder.itemView.getContext())
                .load(row.get("thumbnail"))
                .centerCrop()
                .into(contactHolder.thumbnailImage);
        contactHolder.titleText.setText(row.get("title"));

    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    public void addAll(List<Map<String, String>> data) {
        this.data.addAll(data);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumbnailImage;
        private TextView titleText;
        public ViewHolder(View itemView) {
            super(itemView);
            thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
            titleText = (TextView) itemView.findViewById(R.id.title);
        }
    }


}
