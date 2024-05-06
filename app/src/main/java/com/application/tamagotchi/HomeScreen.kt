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
        var feedCounter = 0 // will count how many time the feed button will be clicked
        var playCounter = 0// will count how many time the play button will be clicked
        var cleanCounter = 0// will count how many time the clean button will be clicked

        // Create Feed button functionality
        btnFeed.setOnClickListener {

            if(feedCounter < 10){// Will ensure that the counter stops incrementing when it reaches 10
                feedCounter++ // increment the counter by 1
            }
            var random = (1..5).random() // generate a random number between 1 and 5
            // The switch statement will assign a petImage resource based on the value generated above
            when(random){
                1 -> petImage.setImageResource(R.drawable.eating1)// assign the petImage to the eating1 resource
                2 -> petImage.setImageResource(R.drawable.eating2)// assign the petImage to the eating2 resource
                3 -> petImage.setImageResource(R.drawable.eating3)// assign the petImage to the eating3 resource
                4 -> petImage.setImageResource(R.drawable.eating4)// assign the petImage to the eating4 resource
                5 -> petImage.setImageResource(R.drawable.eating5)// assign the petImage to the eating5 resource
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        // create play button functionality
        btnPlay.setOnClickListener {
            if(playCounter < 10){// Will ensure that the counter stops incrementing when it reaches 10
                playCounter++ // increment the counter by 1
            }
            var random = (1..5).random()// generate a random number between 1 and 5
            // The switch statement will assign a petImage resource based on the value generated above
            when(random){
                1 -> petImage.setImageResource(R.drawable.playing1)// assign the petImage to the playing1 resource
                2 -> petImage.setImageResource(R.drawable.playing2)// assign the petImage to the playing2 resource
                3 -> petImage.setImageResource(R.drawable.playing3)// assign the petImage to the playing3 resource
                4 -> petImage.setImageResource(R.drawable.playing4)// assign the petImage to the playing4 resource
                5 -> petImage.setImageResource(R.drawable.playing5)// assign the petImage to the playing5 resource
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        btnClean.setOnClickListener {
            if(cleanCounter < 10){// Will ensure that the counter stops incrementing when it reaches 10
                cleanCounter++ // increment the counter by 1
            }
            var random = (1..5).random()// generate a random number between 1 and 5
            // The switch statement will assign a petImage resource based on the value generated above
            when(random){
                1 -> petImage.setImageResource(R.drawable.clean1)// assign the petImage to the clean1 resource
                2 -> petImage.setImageResource(R.drawable.clean2)// assign the petImage to the clean2 resource
                3 -> petImage.setImageResource(R.drawable.clean3)// assign the petImage to the clean3 resource
                4 -> petImage.setImageResource(R.drawable.clean4)// assign the petImage to the clean4 resource
                5 -> petImage.setImageResource(R.drawable.clean5)// assign the petImage to the clean5 resource
            }

            // Display all the counter variables
            tvFeedResult.text = feedCounter.toString()
            tvPlayResult.text = playCounter.toString()
            tvCleanResult.text = cleanCounter.toString()
        }

        // Button to go back to the starting page
        btnBackToStart.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)// this will initialize a new activity
            startActivity(intent)// start the activity that was initialized
        }

        // a button to clear all the fields
        btnClear.setOnClickListener {
            val newValue = 0 // create a variable to reassign all the values
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