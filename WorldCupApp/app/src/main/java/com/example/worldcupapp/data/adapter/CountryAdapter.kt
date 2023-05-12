package com.example.worldcupapp.data.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.worldcupapp.data.model.Country
import com.example.worldcupapp.databinding.ListItemBinding

class CountryAdapter (private var activity: Activity, private var items: ArrayList<Country>): BaseAdapter () {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding
        val view: View

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(activity)
            binding = ListItemBinding.inflate(layoutInflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ListItemBinding
        }

        val countries = items[position]
        binding.countryName.text = countries.name
        binding.cupWins.text = countries.cupWins
        binding.flagImage.setImageResource(countries.flagImage)


        view.setOnClickListener{

            Toast.makeText(activity, "You clicked ${countries.name}", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private class ViewHolder(private val binding: ListItemBinding){
        var textName: TextView? = null
        var textCupWins: TextView? = null
        var flagImage: ImageView? = null

        init {
            this.textName = binding.countryName
            this.textCupWins = binding.cupWins
            this.flagImage = binding.flagImage
        }
    }
}