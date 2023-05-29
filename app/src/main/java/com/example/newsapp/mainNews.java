package com.example.newsapp;

import java.util.ArrayList;

public class mainNews {

    private String status, totalResults;
    private ArrayList<NewsModel> newsModelArrayList;

    public mainNews(String status, String totalResults, ArrayList<NewsModel> newsModelArrayList) {
        this.status = status;
        this.totalResults = totalResults;
        this.newsModelArrayList = newsModelArrayList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getNewsModelArrayList() {
        return newsModelArrayList;
    }

    public void setNewsModelArrayList(ArrayList<NewsModel> newsModelArrayList) {
        this.newsModelArrayList = newsModelArrayList;
    }
}
