package com.example.worldcupapp

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.worldcupapp.data.adapter.CountryAdapter
import com.example.worldcupapp.data.model.Country
import com.example.worldcupapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adapter View
        var listView = binding.listview

        //Adapter
        var adapter = CountryAdapter(this, generateData())

        listView.adapter = adapter

        adapter.notifyDataSetChanged()

    }

    fun generateData(): ArrayList<Country>{
        var result = ArrayList<Country> ()

        var country1 = Country(
            "Brazil",
            "5",
            R.drawable.brazil
        )

        var country2 = Country(
            "France",
            "4",
            R.drawable.france
        )

        var country3 = Country(
            "Germany",
            "3",
            R.drawable.germany
        )

        var country4 = Country(
            "Spain",
            "2",
            R.drawable.spain
        )

        var country5 = Country(
            "United Kingdom",
            "0",
            R.drawable.unitedkingdom
        )

        var country6 = Country(
            "Saudi Arabia",
            "0",
            R.drawable.saudiarabia
        )

        var country7 = Country(
            "United States",
            "0",
            R.drawable.unitedstates
        )

        for (i in 1..100){
            result.add(country1)
            result.add(country2)
            result.add(country3)
            result.add(country4)
            result.add(country5)
            result.add(country6)
            result.add(country7)
        }


        return result
    }
}