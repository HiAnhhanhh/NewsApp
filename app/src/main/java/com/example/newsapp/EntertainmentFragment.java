package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.databinding.FragmentEntertainmentBinding;

public class EntertainmentFragment extends Fragment {

    FragmentEntertainmentBinding binding;


    public EntertainmentFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEntertainmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}