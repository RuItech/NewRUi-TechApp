package com.example.ru_itech.CommonUI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ru_itech.CommonUI.Api.Article;
import com.example.ru_itech.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewholder> {

    List<Article> articles;

    public NewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new viewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Article article = articles.get(position);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.author.setText(article.getAuthor());
        holder.publish.setText(article.getPublishedAt());

        Picasso.get().load(article.getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView description,title,publish,author;
        ImageView image;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            title = itemView.findViewById(R.id.title);
            publish = itemView.findViewById(R.id.publish);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.image);
        }
    }
}
