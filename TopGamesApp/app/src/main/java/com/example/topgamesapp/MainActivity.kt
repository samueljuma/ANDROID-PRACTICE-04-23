package com.example.topgamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topgamesapp.data.adapter.GameAdapter
import com.example.topgamesapp.data.model.GameModel
import com.example.topgamesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adapter View

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )


        //Data Source

        var gamesList: ArrayList<GameModel> = ArrayList()

        val g1 = GameModel(R.drawable.card1, "Horizon Chase")
        val g2 = GameModel(R.drawable.card2, "PUBG")
        val g3 = GameModel(R.drawable.card3, "Head Ball 2")
        val g4 = GameModel(R.drawable.card4, "Hooked On You")
        val g5 = GameModel(R.drawable.card5, "FIFA 2022")
        val g6 = GameModel(R.drawable.card6, "Fortnite")


        for (i in 1..100) {
            gamesList.add(g1)
            gamesList.add(g2)
            gamesList.add(g3)
            gamesList.add(g4)
            gamesList.add(g5)
            gamesList.add(g6)
        }


        var adapter = GameAdapter(gamesList)

        recyclerView.adapter = adapter

    }
}