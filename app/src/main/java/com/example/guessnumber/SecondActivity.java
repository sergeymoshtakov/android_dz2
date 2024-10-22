package com.example.guessnumber;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;

public class SecondActivity extends ComponentActivity {

    private int attemptCount = 0;
    private int userNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button guessButton = findViewById(R.id.guessButton);
        EditText numberInput = findViewById(R.id.numberInput);
        TextView resultText = findViewById(R.id.resultText);
        Button backButton = findViewById(R.id.backButton);

        // Получение переданного числа
        userNumber = getIntent().getIntExtra("userNumber", -1);

        // Обработчик нажатия на кнопку "Угадать"
        guessButton.setOnClickListener(v -> {
            String userInput = numberInput.getText().toString();

            if (!userInput.isEmpty()) {
                int userGuess = Integer.parseInt(userInput);
                attemptCount++;

                if (userGuess < userNumber) {
                    resultText.setText("Ваше число меньше. Попробуйте ещё раз.");
                } else if (userGuess > userNumber) {
                    resultText.setText("Ваше число больше. Попробуйте ещё раз.");
                } else {
                    resultText.setText("Поздравляем! Вы угадали число за " + attemptCount + " попыток!");
                    resetGame();
                }
            } else {
                Toast.makeText(SecondActivity.this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработчик нажатия на кнопку "Назад"
        backButton.setOnClickListener(v -> finish());
    }

    // Сброс игры
    private void resetGame() {
        attemptCount = 0;
    }
}
