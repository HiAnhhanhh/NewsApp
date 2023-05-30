package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.databinding.FragmentTechBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TechFragment extends Fragment {

    FragmentTechBinding binding;

    String ApiKey = "4429cfff6bc54ba8beac5ba451677bcb";
    String country = "in";
    String category = "technology";
    Adapter adapter;
    ArrayList<NewsModel> newsModelArrayList;

    public TechFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentTechBinding.inflate(inflater, container, false);
        findNews();
        newsModelArrayList = new ArrayList<>();
        adapter = new Adapter(getContext(), newsModelArrayList);
        binding.newsTechRec.setAdapter(adapter);
        binding.newsTechRec.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    private void findNews() {
        ApiService.apiService.getCategoryNews(country,category,100, ApiKey ).enqueue(new Callback<mainNews>() {
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