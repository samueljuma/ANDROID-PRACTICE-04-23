package com.example.sharedpreferencesapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sharedpreferencesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userNameTxtView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.editText
        userNameTxtView = binding.userNameTxtView
        val saveMeBtn = binding.saveMeBtn

        userNameTxtView.text = getUserName()

        saveMeBtn.setOnClickListener {
            val enteredText = editText.text.toString()
            saveNameInSharedPreferences(enteredText)
        }

    }

    private fun saveNameInSharedPreferences(enteredText: String) {
        val sharedPref = getSharedPreferences("UserName",Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putString("username", enteredText)
            apply()
        }
    }

    //Reading the data from shared preferences
    private fun getUserName (): String?{
        val sharedPreferences = getSharedPreferences("UserName",Context.MODE_PRIVATE)
        return sharedPreferences.getString("username", "Last UserName")
    }

}