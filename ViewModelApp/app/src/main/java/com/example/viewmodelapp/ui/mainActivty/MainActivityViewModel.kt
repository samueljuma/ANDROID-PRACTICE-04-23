package com.example.viewmodelapp.ui.mainActivty

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var count: Int = 0

    fun getCount():Int {
        return count
    }
    fun incrementCount(): Int {
        return ++count
    }

}