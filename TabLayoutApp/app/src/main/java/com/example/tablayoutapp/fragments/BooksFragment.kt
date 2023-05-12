package com.example.tablayoutapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablayoutapp.R
import com.example.tablayoutapp.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

}