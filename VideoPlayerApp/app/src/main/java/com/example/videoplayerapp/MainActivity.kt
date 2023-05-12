package com.example.videoplayerapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.videoplayerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Displaying videos from local storage
        val videoView1 = binding.videoView1
        videoView1.setVideoPath(
            "android.resource://"
                    + packageName + "/"
                    + R.raw.mountains)


        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView1)
        mediaController.setMediaPlayer(videoView1)
        videoView1.setMediaController(mediaController)
        videoView1.start()

        //Displaying videos from the internet
        val videoView2 = binding.videoView2

        val uri = Uri.parse("https://static.videezy.com/system/resources/previews/000/002/231/original/5226496.mp4")

        videoView2.setVideoURI(uri)

        //Media Controller
        val mediaController2 = MediaController(this)
        mediaController2.setAnchorView(videoView2)
        mediaController2.setMediaPlayer(videoView2)
        videoView2.setMediaController(mediaController2)
        videoView2.start()

    }
}