package com.example.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.activity.WebActivity;
import com.example.newsapp.databinding.RowNewsBinding;
import com.example.newsapp.model.Article;
import com.example.newsapp.view.BusinessNewsRepository;

import java.util.List;

public class BusinessNewsAdapter extends RecyclerView.Adapter<BusinessNewsAdapter.ViewHolder> {
    private List<Article> articles;
    private Context context;

    public BusinessNewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.rowNewsBinding.setData(article);

        holder.rowNewsBinding.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", article.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RowNewsBinding rowNewsBinding;

        public ViewHolder(@NonNull RowNewsBinding binding) {
            super(binding.getRoot());
            this.rowNewsBinding = binding;
        }
    }

}
