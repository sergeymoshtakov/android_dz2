package com.example.guessnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var randomNumber = (1..100).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberInput: EditText = findViewById(R.id.numberInput)
        val startWithUserNumberButton: Button = findViewById(R.id.startWithUserNumberButton)
        val startWithRandomNumberButton: Button = findViewById(R.id.startWithRandomNumberButton)

        startWithUserNumberButton.setOnClickListener {
            val userInput = numberInput.text.toString()

            if (userInput.isNotEmpty()) {
                val userNumber = userInput.toInt()
                if (userNumber in 1..100) {
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("userNumber", userNumber)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Введите число от 1 до 100", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show()
            }
        }

        startWithRandomNumberButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("userNumber", randomNumber)
            startActivity(intent)
        }
    }
}
