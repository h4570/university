// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details);

        TextView recipeDetailsTextView = findViewById(R.id.recipeDetailsTextView);

        Intent intent = getIntent();
        String recipeText = intent.getStringExtra("recipeText");

        if (recipeText != null && !recipeText.isEmpty()) {
            recipeDetailsTextView.setText(recipeText);
        } else {
            recipeDetailsTextView.setText("Brak szczegółów przepisu");
        }

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeDetails.this, Eat.class);
                startActivity(intent);
            }
        });
    }


}