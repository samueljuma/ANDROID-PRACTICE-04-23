package com.example.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerapp.adapters.ViewPagerAdapter
import com.example.viewpagerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(this)
    }
}