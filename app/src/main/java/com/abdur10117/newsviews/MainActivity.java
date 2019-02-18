package com.abdur10117.newsviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abdur10117.newsviews.Model.NewsResponse;
import com.abdur10117.newsviews.Model.NewsModel;
import com.abdur10117.newsviews.adapter.NewsAdapter;
import com.abdur10117.newsviews.api.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private String TAG="myTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerViewNews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getGetNews();
        getGetNews2();
    }

    private void getGetNews2() {

    }

    public void getGetNews(){

        Call<NewsResponse> call = RetrofitClient.getInstance().getApi().getNews();

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Code: " + response.code());
                    return;
                }

                NewsResponse newsResponse = response.body();
                if(newsResponse != null && newsResponse.getStatus().equalsIgnoreCase("ok")){

                    List<NewsModel> modelList = newsResponse.getNewsModels();
                    NewsAdapter googleNewsAdapter = new NewsAdapter(modelList);
                    recyclerView.setAdapter(googleNewsAdapter);

                }else{
                    if(newsResponse != null) {
                        Log.d(TAG, "onResponse:  data is properly not received");
                    }else{
                        Log.d(TAG, "onResponse: response is null");
                    }
                }

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: News Response" + t.getMessage());
            }
        });

    }



}
