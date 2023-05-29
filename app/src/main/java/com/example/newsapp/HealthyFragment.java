package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.databinding.FragmentHealthyBinding;

public class HealthyFragment extends Fragment {

    FragmentHealthyBinding binding;


    public HealthyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHealthyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}