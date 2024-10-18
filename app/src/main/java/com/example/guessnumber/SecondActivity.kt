package com.example.guessnumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {

    private var attemptCount = 0
    private var userNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val guessButton: Button = findViewById(R.id.guessButton)
        val numberInput: EditText = findViewById(R.id.numberInput)
        val resultText: TextView = findViewById(R.id.resultText)
        val backButton: Button = findViewById(R.id.backButton)

        userNumber = intent.getIntExtra("userNumber", -1)

        guessButton.setOnClickListener {
            val userInput = numberInput.text.toString()

            if (userInput.isNotEmpty()) {
                val userGuess = userInput.toInt()
                attemptCount++

                when {
                    userGuess < userNumber -> {
                        resultText.text = "Ваше число меньше. Попробуйте ещё раз."
                    }
                    userGuess > userNumber -> {
                        resultText.text = "Ваше число больше. Попробуйте ещё раз."
                    }
                    else -> {
                        resultText.text = "Поздравляем! Вы угадали число за $attemptCount попыток!"
                        resetGame()
                    }
                }
            } else {
                Toast.makeText(this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun resetGame() {
        attemptCount = 0
    }
}
