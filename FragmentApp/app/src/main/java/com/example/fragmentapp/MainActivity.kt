package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentapp.databinding.ActivityMainBinding
import com.example.fragmentapp.databinding.Fragment1Binding
import com.example.fragmentapp.ui.Fragment1
import com.example.fragmentapp.ui.Fragment2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn1 = binding.btn1
        val btn2 = binding.btn2

        btn1.setOnClickListener {
            val fragment1 = Fragment1()

            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(
                binding.frame1.id, fragment1
            ).commit()

        }
        btn2.setOnClickListener {
            val fragment2 = Fragment2()

            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(
                binding.frame2.id, fragment2
            ).commit()

        }
    }
}