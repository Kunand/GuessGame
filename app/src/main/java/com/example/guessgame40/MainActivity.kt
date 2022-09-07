package com.example.guessgame40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val easy_button = findViewById<Button>(R.id.easy)
        val medium_button = findViewById<Button>(R.id.medium)
        val hard_button = findViewById<Button>(R.id.hard)

        var result: String

        easy_button.setOnClickListener(){
            result = "10"
            val intent = Intent(this, GameActivity:: class.java)
                intent.putExtra("difficulty", result)
                startActivity(intent)


        }

        medium_button.setOnClickListener(){
            result = "100"
            val intent = Intent(this, GameActivity:: class.java)
            intent.putExtra("difficulty", result)
            startActivity(intent)


        }

        hard_button.setOnClickListener(){
            result = "1000"
            val intent = Intent(this, GameActivity:: class.java)
            intent.putExtra("difficulty", result)
            startActivity(intent)


        }



    }
}