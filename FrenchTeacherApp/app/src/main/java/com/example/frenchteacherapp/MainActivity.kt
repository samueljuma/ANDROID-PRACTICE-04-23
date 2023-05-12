package com.example.frenchteacherapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.frenchteacherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }
    fun sayTheColor (view: View){
        val clickedButton : Button = view as Button
        var mediaPlayer: MediaPlayer = MediaPlayer.create(
            this,
            resources.getIdentifier(
                clickedButton.tag.toString(),
                "raw",
                packageName
            ))
        mediaPlayer.start()
    }
}