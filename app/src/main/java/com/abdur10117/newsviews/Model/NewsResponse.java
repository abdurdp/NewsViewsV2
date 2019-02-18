package com.abdur10117.newsviews.Model;


import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<NewsModel> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsModel> getNewsModels() {
        return articles;
    }
}