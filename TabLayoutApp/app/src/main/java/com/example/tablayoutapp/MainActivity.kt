package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayoutapp.adapters.ViewPagerAdapter
import com.example.tablayoutapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val tabsArray = arrayOf("Books", "Games", "Movies")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(this)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.text = tabsArray[position]
        }.attach()
    }
}