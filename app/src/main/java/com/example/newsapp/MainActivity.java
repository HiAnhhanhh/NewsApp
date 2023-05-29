package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.newsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.tabLayout.setupWithViewPager(binding.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        pagerAdapter.addFragment(new HomeFragment(),"Home");
        pagerAdapter.addFragment(new ScienceFragment(),"Science");
        pagerAdapter.addFragment(new EntertainmentFragment(),"Entertainment");
        pagerAdapter.addFragment(new HealthyFragment(),"Healthy");
        pagerAdapter.addFragment(new TechFragment(),"Tech");
        pagerAdapter.addFragment(new SportsFragment(),"Sport");

        binding.viewPager.setAdapter(pagerAdapter);

    }
}