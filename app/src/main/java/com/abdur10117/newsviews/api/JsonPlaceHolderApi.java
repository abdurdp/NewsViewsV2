package com.abdur10117.newsviews.api;

import com.abdur10117.newsviews.Model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("top-headlines?sources=google-news&apiKey=cc39eb8a0bf94781933a765ee91dd8a5")
    //@GET("everything?q=bitcoin&from=2019-01-17&sortBy=publishedAt&apiKey=b686e3d460ce465fafa5bf1e37553c7d")
    Call<NewsResponse> getNews();

}