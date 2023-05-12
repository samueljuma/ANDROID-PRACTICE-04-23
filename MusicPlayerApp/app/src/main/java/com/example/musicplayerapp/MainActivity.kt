package com.example.musicplayerapp

import android.media.MediaActionSound
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.provider.MediaStore.Audio.Media
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.musicplayerapp.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    // variables
    var startTime = 0.0
    var finalTime = 0.0
    var forwardTime = 1000
    var backwardTime = 10000
    var oneTimeOnly = 0

    // Handler
    var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize media player
        mediaPlayer = MediaPlayer.create(
            this,
            R.raw.myaudio
        )

        //Set seekbar clickable to false
        binding.seekBar.isClickable = false

        binding.playBtn.setOnClickListener {
           mediaPlayer.start()

            finalTime = mediaPlayer.duration.toDouble()
            finalTime = mediaPlayer.currentPosition.toDouble()

            if (oneTimeOnly == 0){
                binding.seekBar.max =finalTime.toInt()
                oneTimeOnly = 1
            }

            binding.timeLeft.text = startTime.toString()
            binding.seekBar.progress = startTime.toInt()

            handler.postDelayed(UpdateSongTime,100)

        }


        //Set the Music Title
        binding.songTitle.text = "" + resources.getResourceEntryName(R.raw.myaudio)

        //Pause Btn
        binding.pauseBtn.setOnClickListener {
            mediaPlayer.pause()
        }

        //Forward Button
        binding.forwardBtn.setOnClickListener {
            var temp = startTime.toInt()
            if((temp + forwardTime) <= finalTime) {
                startTime = startTime + forwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }
            else{
                Toast.makeText(this, "Cant Jump forward", Toast.LENGTH_LONG).show()
            }
        }


        //Back Button
        binding.backBtn.setOnClickListener {
            var temp = startTime.toInt()
            if((temp - backwardTime) > 0){
                startTime = startTime - backwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }
            else{
                Toast.makeText(this, "Cant Jump backward", Toast.LENGTH_LONG).show()
            }
        }

        }
    //Creating the Runnable
    val UpdateSongTime: Runnable = object : Runnable {
        override fun run() {
            startTime = mediaPlayer.currentPosition.toDouble()
            binding.timeLeft.text = ""+ String.format("%d min, %d sec",TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(startTime.toLong() - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(startTime.toLong())
            )))

            binding.seekBar.progress = startTime.toInt()
            binding.seekBar.postDelayed(this,100)
        }
    }
}