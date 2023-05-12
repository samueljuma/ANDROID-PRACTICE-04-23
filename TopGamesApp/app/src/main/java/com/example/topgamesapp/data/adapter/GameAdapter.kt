package com.example.topgamesapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.topgamesapp.data.model.GameModel
import com.example.topgamesapp.databinding.CardItemLayoutBinding

class GameAdapter (val gameList: ArrayList<GameModel>) : RecyclerView.Adapter<GameAdapter.ViewHolder> (){


    inner class ViewHolder (binding: CardItemLayoutBinding): RecyclerView.ViewHolder (binding.root){
        var gameImage : ImageView
        var gameTitle : TextView
        init{
            gameImage = binding.carViewImg
            gameTitle = binding.carViewTxt

            binding.root.setOnClickListener{
                Toast.makeText(binding.root.context, "You clicked ${gameTitle.text}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameImage.setImageResource(gameList[position].imgCard)
        holder.gameTitle.text = gameList[position].txtCard
    }

    override fun getItemCount(): Int {
       return gameList.size
    }
}