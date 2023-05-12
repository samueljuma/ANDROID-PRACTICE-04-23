package com.example.jetpackdatastoreapp


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope

import com.example.jetpackdatastoreapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val Context.dataStore by preferencesDataStore(
        name = "settings"
    )
    private val UserNameKey = stringPreferencesKey("username")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.editText
        val usernameTxtView = binding.userNameTxtView
        val saveMeBtn = binding.saveMeBtn

        lifecycleScope.launch {
            usernameTxtView.text = getUserName().toString()
        }

        saveMeBtn.setOnClickListener {
            val userNameText = editText.text.toString()
            lifecycleScope.launch {
               saveUserName(userNameText)
            }
        }




    }
    private suspend fun saveUserName (userName: String){
        dataStore.edit {
            it[UserNameKey] = userName
        }
    }

    private suspend fun getUserName (): String? {
        val preferences = dataStore.data.first()
        return preferences[UserNameKey]
    }
}