package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.databinding.FragmentSportsBinding;

public class SportsFragment extends Fragment {

    FragmentSportsBinding binding;


    public SportsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSportsBinding.inflate(inflater, container, false );
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}