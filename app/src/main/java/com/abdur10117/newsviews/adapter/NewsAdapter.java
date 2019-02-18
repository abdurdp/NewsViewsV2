package com.abdur10117.newsviews.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdur10117.newsviews.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import com.abdur10117.newsviews.Model.NewsModel;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    public static final String TAG = "MyTag";
     private List<NewsModel> newsListModel;
    int mPosition;

    /*public AllProductsAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }*/


    @NonNull
    private View.OnClickListener detailsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            /*Intent intent = new Intent(context, ProductViewActivity.class);
            SharedPreferences pref = context.getSharedPreferences("EncProductId", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();


            editor.putString("productId", newsListModel.get(position).getProductId() ); // Storing string
            editor.commit();
            context.startActivity(intent);*/

        }
    };


    public NewsAdapter(List<NewsModel> newsListModel) {
        this.newsListModel = newsListModel;


    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_card_view, viewGroup, false);
        return new NewsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, final int position) {

        viewHolder.tvNewsHeadline.setText(newsListModel.get(position).getTitle());

        String urlToImage = newsListModel.get(position).getUrlToImage();
        Picasso.get().load(urlToImage).into(viewHolder.itemImage);
        viewHolder.tvDate.setText(newsListModel.get(position).getPublishedAt());


        viewHolder.itemImage.setOnClickListener(detailsListener);
        viewHolder.tvNewsHeadline.setOnClickListener(detailsListener);
        viewHolder.tvDate.setOnClickListener(detailsListener);


    }

    @Override
    public int getItemCount() {
        return newsListModel.size();
    }

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView tvNewsHeadline, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            tvNewsHeadline = itemView.findViewById(R.id.tvNewsHeadline);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }

}