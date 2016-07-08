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
 * Created by 江老师 on 6/5/16.
 */
public class ComplexRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_CONTACT = 2;
    private List<Map<String,String> > data = new ArrayList<>();

    public ComplexRecyclerAdapter(List<Map<String, String>> data){
        if(data != null) this.data = data;
    }

    public void addAll(List<Map<String,String>> data){
        this.data.addAll(data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch(viewType){
            case TYPE_CONTACT:
                return new ContactViewHolder(inflater.inflate(R.layout.item_simple_contact,null,false));
            default:
                return new ArticleViewHolder(inflater.inflate(R.layout.item_simple_thumbnail,null,false));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * If you have different view according to the data set, you should implement this method to tell
     * {@link #onCreateViewHolder(ViewGroup,int)} which viewType you'll use.
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position % 3 == 0 ? TYPE_CONTACT : TYPE_ARTICLE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Map<String,String> row = data.get(position);
        switch(holder.getItemViewType()){
            case TYPE_CONTACT:
                ContactViewHolder contactHolder = (ContactViewHolder) holder;
                Glide.with(holder.itemView.getContext())
                        .load(row.get("thumbnail"))
                        .into(contactHolder.thumbnailImage);
                contactHolder.displayNameText.setText(row.get("title"));
                break;
            default:
                ArticleViewHolder articleHolder = (ArticleViewHolder) holder;
                Glide.with(holder.itemView.getContext())
                        .load(row.get("thumbnail"))
                        .centerCrop()
                        .into(articleHolder.thumbnailImage);
                articleHolder.titleText.setText(row.get("title"));

        }
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumbnailImage;
        private TextView displayNameText;
        public ContactViewHolder(View itemView) {
            super(itemView);
            thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
            displayNameText = (TextView) itemView.findViewById(R.id.display_name);
        }
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumbnailImage;
        private TextView titleText;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
            titleText = (TextView) itemView.findViewById(R.id.title);
        }
    }

}
