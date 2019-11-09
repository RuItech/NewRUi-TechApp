package com.example.ru_itech.CommonFiles.Api;

import java.util.ArrayList;

public class News {
    public News(String status, int totalResults, ArrayList<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public News() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    private String status;
    private int totalResults;
    ArrayList < Article > articles = new ArrayList< Article>();

}
