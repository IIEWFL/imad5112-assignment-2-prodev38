package com.application.tamagotchi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Create all the components
        val petImage = findViewById<ImageView>(R.id.imageView) // imageView component
        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted) // button component

        //Select a random image
        var randomImage = (1..5).random()// generates a random value between 1 and 5, then assigns to random variable.

        // The switch statement will assign a petImage resource based on the value generated above
        when(randomImage){
            1 -> petImage.setImageResource(R.drawable.home1)// assign the petImage to the home1 resource
            2 -> petImage.setImageResource(R.drawable.home2)// assign the petImage to the home2 resource
            3 -> petImage.setImageResource(R.drawable.home3)// assign the petImage to the home3 resource
            4 -> petImage.setImageResource(R.drawable.home4)// assign the petImage to the home4 resource
            5 -> petImage.setImageResource(R.drawable.home5)// assign the petImage to the home5 resource
        }

        btnGetStarted.setOnClickListener{
            val intent = Intent(this, HomeScreen::class.java) // this will initialize a new activity
            startActivity(intent) // start the activity that was initialized
        }




    }
}