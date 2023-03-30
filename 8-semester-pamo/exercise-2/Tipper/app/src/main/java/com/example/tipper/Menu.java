// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button bmiButton = findViewById(R.id.bmiButton);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, BMI.class);
                startActivity(intent);
            }
        });

        Button caloriesButton = findViewById(R.id.caloriesButton);
        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Calories.class);
                startActivity(intent);
            }
        });

        Button eatButton = findViewById(R.id.eatButton);
        eatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Eat.class);
                startActivity(intent);
            }
        });

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Start.class);
                startActivity(intent);
            }
        });
    }

}