package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {
    @SerializedName("status")
    public String status;
    public int totalResults;
    public List<Article> articles;


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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
