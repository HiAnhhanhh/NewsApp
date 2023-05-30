package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {

    }
    ArrayList<NewsModel> newsModelArrayList;
    String ApiKey = "4429cfff6bc54ba8beac5ba451677bcb";
    String country = "in";
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        newsModelArrayList = new ArrayList<>();
        findNews();
        adapter = new Adapter(getContext(), newsModelArrayList);
        binding.homeRec.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.homeRec.setAdapter(adapter);


        return binding.getRoot();
    }

    private void findNews() {
        ApiService.apiService.getNews(country,100, ApiKey).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                newsModelArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });

    }
}