package com.example.androiddevsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androiddevsapp.databinding.ActivityMainBinding
import com.example.androiddevsapp.model.Developer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val developer: Developer = Developer("Samuel Juma","Expert", 5)

        binding.developer = developer

    }
}