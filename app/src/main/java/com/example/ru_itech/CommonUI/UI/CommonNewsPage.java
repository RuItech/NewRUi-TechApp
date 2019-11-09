package com.example.ru_itech.CommonUI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ru_itech.CommonUI.Adapters.DashBoardAdapter;
import com.example.ru_itech.CommonUI.Adapters.NewsAdapter;
import com.example.ru_itech.CommonUI.Api.ApiClient;
import com.example.ru_itech.CommonUI.Api.Article;
import com.example.ru_itech.CommonUI.Api.News;
import com.example.ru_itech.CommonUI.Api.NewsApi;
import com.example.ru_itech.CommonUI.Aunthetication.DashBoard;
import com.example.ru_itech.CommonUI.DasboardModel;
import com.example.ru_itech.R;

import java.util.ArrayList;
import java.util.List;

public class CommonNewsPage extends AppCompatActivity {
     List<Article> articles;
     NewsAdapter adapter;
     RecyclerView newsRecycler;
     ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_news_page);

        Context context;
        progressDialog = new ProgressDialog(CommonNewsPage.this);
        progressDialog.setTitle("Loading Content...");

        setUpRecyclerView();

        Intent i= getIntent();
        String school = i.getStringExtra("School");

        TextView titleText = findViewById(R.id.title);
        titleText.setText(school+" "+"News");

        NewsApi api = ApiClient.getClient().create(NewsApi.class);
        progressDialog.show();
        api.getAllNews(school,"fb3afef6df5945f2999a0a8331a63030").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if(response!=null){
                    Toast.makeText(CommonNewsPage.this,"Success",Toast.LENGTH_SHORT).show();
                    News news = response.body();
                    assert news != null;
                    List<Article> article = news.getArticles();

                    articles.addAll(article);
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(CommonNewsPage.this,t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });


    }

    public void setUpRecyclerView(){
        newsRecycler = findViewById(R.id.news);

        articles = new ArrayList<>();
        adapter = new NewsAdapter(articles,CommonNewsPage.this );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CommonNewsPage.this,LinearLayoutManager.VERTICAL,false);
        newsRecycler.setLayoutManager(linearLayoutManager);
        newsRecycler.setAdapter(adapter);


    }

}
