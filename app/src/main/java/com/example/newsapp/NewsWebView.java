package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.webkit.WebViewClient;

import com.example.newsapp.databinding.ActivityNewsWebViewBinding;

public class NewsWebView extends AppCompatActivity {

    ActivityNewsWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsWebViewBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        setSupportActionBar(binding.toolBar);
        String url = getIntent().getStringExtra("url");
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(url);

    }
}