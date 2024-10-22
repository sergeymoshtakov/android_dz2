package com.example.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import java.util.Random;

public class MainActivity extends ComponentActivity {

    private int randomNumber = new Random().nextInt(100) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numberInput = findViewById(R.id.numberInput);
        Button startWithUserNumberButton = findViewById(R.id.startWithUserNumberButton);
        Button startWithRandomNumberButton = findViewById(R.id.startWithRandomNumberButton);

        startWithUserNumberButton.setOnClickListener(v -> {
            String userInput = numberInput.getText().toString();

            if (!userInput.isEmpty()) {
                int userNumber = Integer.parseInt(userInput);
                if (userNumber >= 1 && userNumber <= 100) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("userNumber", userNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Введите число от 1 до 100", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show();
            }
        });

        startWithRandomNumberButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("userNumber", randomNumber);
            startActivity(intent);
        });
    }
}
