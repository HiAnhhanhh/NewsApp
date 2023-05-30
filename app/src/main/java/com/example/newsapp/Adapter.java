package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.databinding.NewsItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<NewsModel> newsModelArrayList;

    public Adapter(Context context, ArrayList<NewsModel> newsModelArrayList) {
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }

    NewsItemBinding binding;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = NewsItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        NewsModel newsModel = newsModelArrayList.get(position);
        holder.title.setText(newsModel.getTitle());
        holder.description.setText(newsModel.getDescription());
        holder.publishedAt.setText("publishedAt :"+newsModel.getPublishedAt());
        holder.author.setText(newsModel.getAuthor());

        Glide.with(context).load(newsModel.getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsWebView.class);
                intent.putExtra("url", newsModelArrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, publishedAt, author;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = binding.title;
            description=binding.descriptionTv;
            imageView = binding.newsImage;
            publishedAt = binding.publishedAt;
            author = binding.authorTv;
        }
    }
}
