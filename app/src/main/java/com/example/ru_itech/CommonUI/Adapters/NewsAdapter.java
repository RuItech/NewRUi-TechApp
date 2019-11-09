package com.example.ru_itech.CommonUI.Adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
    public boolean on_attach = true;


    public NewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    Context context;


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);

    }

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

        Picasso.with(context).load(article.getUrlToImage()).into(holder.image);
        RightLeft(holder.itemView,position);

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

    public void RightLeft(View itemview, int i) {
        if (!on_attach) {
            i = -1;
        }


        boolean isNotFirst = i == -1;
        i = i + 1;
        itemview.setTranslationX(itemview.getX() + 400);
        itemview.setAlpha(0.f);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(itemview, "translationX", itemview.getX(), +400,0);
        ObjectAnimator animatorx = ObjectAnimator.ofFloat(itemview, "alpha", 1.f);
        ObjectAnimator.ofFloat(itemview, "alpha", 0.f).start();
        animatorY.setStartDelay(isNotFirst ? 150 : (i * 150));
        animatorY.setDuration((isNotFirst ? 2 : 1) * 150);
        set.playTogether(animatorY, animatorx);
        set.start();

    }
}
