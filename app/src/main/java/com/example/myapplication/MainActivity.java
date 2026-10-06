package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView dado1 = (ImageView) findViewById(R.id.dado1);
    ImageView dado2 = (ImageView) findViewById(R.id.dado2);
    Button rollButton = (Button) findViewById(R.id.rollButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onRoll(View view) {
        Log.d("Dicee","The Button has pressed");
        Random randomNumberGenerator = new Random();
        int number = randomNumberGenerator.nextInt(6);
        Log.d("Dicee","The random number is : " + number);
        int[] diceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        dado1.setImageResource(diceArray[number]);
        dado2.setImageResource(diceArray[number]);
    }
}