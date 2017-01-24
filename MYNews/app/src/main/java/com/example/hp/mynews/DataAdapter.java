package com.example.hp.mynews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.mynews.datafetch.NewsData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed akl on 1/24/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements View.OnClickListener {

    ArrayList<NewsData> arrayList;
    Context context;
    MainActivity mainActivity;

    NewsData encap = new NewsData();

    public DataAdapter(ArrayList<NewsData> arrayList, Context context, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        ViewHolder viewHolder = new ViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        encap = arrayList.get(position);

        holder.cardView.setTag(position);

        holder.textTitle.setText(encap.getTitle());
        holder.textDesc.setText(encap.getDesc());
        Picasso.with(context).load(encap.getImg()).into(holder.imageNews);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        ImageView imageNews;
        TextView textTitle;
        TextView textDesc;

        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_container);
            imageNews = (ImageView) layout.findViewById(R.id.news_image);
            textTitle = (TextView) layout.findViewById(R.id.title_news);
            textDesc = (TextView) layout.findViewById(R.id.desc_news);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            encap = arrayList.get(position);

            Intent intent = new Intent(mainActivity, DetailsActivity.class);

            intent.putExtra("title", encap.getTitle());
            intent.putExtra("desc", encap.getDesc());
            intent.putExtra("image", encap.getImg());

            mainActivity.startActivity(intent);

        }

    }

}