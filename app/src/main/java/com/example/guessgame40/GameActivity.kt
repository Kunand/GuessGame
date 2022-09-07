package com.example.guessgame40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.guessgame40.databinding.ActivityGameBinding
import java.util.*


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var difficulty = intent.getStringExtra("difficulty")
        val difNum = difficulty?.toIntOrNull()

        Toast.makeText(this, "Guess a number between 0 and $difficulty", Toast.LENGTH_LONG).show()



        fun generateRandomNumber(): Int? {
            val random = Random()
            return difNum?.let { random.nextInt(it) }

        }

        fun countTries() {
            var tries: Int = binding.numberOfTries.text.toString().toInt()
            tries += 1
            binding.numberOfTries.text = tries.toString()
        }

        binding.randomNum.text = generateRandomNumber().toString()
        binding.randomNum.visibility = View.INVISIBLE

        binding.btnGuess.setOnClickListener(){
            val guess: Int = binding.guess.text.toString().toInt()
            var randomGen: Int = binding.randomNum.text.toString().toInt()

            if (guess > randomGen){
                binding.helper.text = "$guess is too high"
                Toast.makeText(this, "Too high", Toast.LENGTH_SHORT).show()
                countTries()
            }
            if(guess < randomGen){
                binding.helper.text = "$guess is too low"
                Toast.makeText(this, "Too low", Toast.LENGTH_SHORT).show()
                countTries()
            }
            if(guess == randomGen){
                binding.helper.text = "$guess is correct"
                Toast.makeText(this, "Correct, you win", Toast.LENGTH_SHORT).show()
                binding.randomNum.visibility = View.VISIBLE
            }

        }


    }
}