package com.example.tablayoutapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablayoutapp.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {

    private lateinit var binding: FragmentGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

}