package com.example.viewpagerapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerapp.MainActivity
import com.example.viewpagerapp.fragments.FragmentOne
import com.example.viewpagerapp.fragments.FragmentThree
import com.example.viewpagerapp.fragments.FragmentTwo

class ViewPagerAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val fragmentCount = 3

    override fun getItemCount(): Int {
        return this.fragmentCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> FragmentOne()
        }
    }

}