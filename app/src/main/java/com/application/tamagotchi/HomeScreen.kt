package com.application.tamagotchi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.renderscript.Sampler.Value
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Create all component variables
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnBackToStart = findViewById<Button>(R.id.btnBackToStart)
        val btnClear = findViewById<Button>(R.id.btnClear)


        // all text view components
        val tvFeedResult = findViewById<TextView>(R.id.tvFeedResult)
        val tvPlayResult = findViewById<TextView>(R.id.tvPlayResult)
        val tvCleanResult = findViewById<TextView>(R.id.tvCleanResult)

        // declare imageView component
        val petImage = findViewById<ImageView>(R.id.imgView2)

        // initialise all counter variables
        var feedCounter = 0
        var playCounter = 0
        var cleanCounter = 0

        // Create Feed button functionality
        btnFeed.setOnClickListener {
            feedCounter++
            var random = (1..5).random()
            when(random){
                1 -> petImage.setImageResource(R.drawable.eating1)
                2 -> petImage.setImageResource(R.drawable.eating2 )
                3 -> petImage.setImageResource(R.drawable.eating3)
                4 -> petImage.setImageResource(R.drawable.eating4)
                5 -> petImage.setImageResource(R.drawable.eating5)
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        // create play button functionality
        btnPlay.setOnClickListener {
            playCounter++
            var random = (1..5).random()
            when(random){
                1 -> petImage.setImageResource(R.drawable.playing1)
                2 -> petImage.setImageResource(R.drawable.playing2)
                3 -> petImage.setImageResource(R.drawable.playing3)
                4 -> petImage.setImageResource(R.drawable.playing4)
                5 -> petImage.setImageResource(R.drawable.playing5)
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        btnClean.setOnClickListener {
            cleanCounter++
            var random = (1..5).random()
            when(random){
                1 -> petImage.setImageResource(R.drawable.clean1)
                2 -> petImage.setImageResource(R.drawable.clean2)
                3 -> petImage.setImageResource(R.drawable.clean3)
                4 -> petImage.setImageResource(R.drawable.clean4)
                5 -> petImage.setImageResource(R.drawable.clean5)
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        btnBackToStart.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // a button to clear all the fields
        btnClear.setOnClickListener {
            val newValue = 0
            tvFeedResult.text = newValue.toString()
            tvCleanResult.text = newValue.toString()
            tvPlayResult.text = newValue.toString()

            // reset all the counters
            playCounter = newValue
            feedCounter = newValue
            cleanCounter = newValue
        }



    }


}