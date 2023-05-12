package com.example.tablayoutapp.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.fragments.BooksFragment
import com.example.tablayoutapp.fragments.GamesFragment
import com.example.tablayoutapp.fragments.MoviesFragment


class ViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    private val tabsCount = 3
    override fun getItemCount(): Int {
        return this.tabsCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> BooksFragment()
            1 -> GamesFragment()
            2 -> MoviesFragment()
            else -> MoviesFragment()
        }
    }
}